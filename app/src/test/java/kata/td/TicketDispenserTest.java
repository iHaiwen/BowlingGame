package kata.td;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by benwu on 14-6-10.
 */
public class TicketDispenserTest {
    @Test
    public void a_trivial_test() {
        assertEquals(5, 2 + 3);
    }

    @Test
    public void aNewTicketShouldHaveTheTurnNumberSubsequentToThePreviousTicket() throws Exception {
        //Arrange
        TicketDispenser ticketDispenser = new TicketDispenser();
        TurnTicket previousTicket = ticketDispenser.getTurnTicket();

        //Act
        TurnTicket newTicket = ticketDispenser.getTurnTicket();

        //Assert
        Assert.assertEquals(1, (newTicket.getTurnNumber() - previousTicket.getTurnNumber()));
    }

    @Test
    public void aNewTicketShouldHaveTheTurnNumberSubsequentToThePreviousTicketFromAnotherDispenser() throws Exception {
        //Arrange
        TicketDispenser anotherDispenser = new TicketDispenser();
        TicketDispenser ticketDispenser = new TicketDispenser();

        //
        TurnTicket previousTicket = anotherDispenser.getTurnTicket();
        TurnTicket newTicket = ticketDispenser.getTurnTicket();

        //Assert
        Assert.assertEquals(1, (newTicket.getTurnNumber() - previousTicket.getTurnNumber()));
    }

    @Test
    public void theTicketDispenserShouldDispenseTheTicketNumber11IfGiveATurnNumber11ToIt() throws Exception {
        //Arrange
        MockTurnNumberSequence mockTurnNumberSequence = new MockTurnNumberSequence();
        mockTurnNumberSequence.arrangeNextTurnNumber(11);
        TicketDispenser ticketDispenser = new TicketDispenser(mockTurnNumberSequence);

        //Act
        TurnTicket ticket = ticketDispenser.getTurnTicket();

        //Assert
        Assert.assertEquals(11, ticket.getTurnNumber());
        mockTurnNumberSequence.verifyMethodGetNextTurnNumberCalledOne();
    }

    @Test
    public void theNumberSequenceOfTheVipCustomersStartsFrom1001() throws Exception {
        //Arrange
        TurnNumberSequence vipCustomerTurnNumberSequence = new TurnNumberSequence(TurnNumberSequence.VIP_CUSTOMER_FIRST_NUMBER);
        TicketDispenser vipCustomerTicketDispenser = new TicketDispenser(vipCustomerTurnNumberSequence);

        //Act
        TurnTicket ticket = vipCustomerTicketDispenser.getTurnTicket();

        //Assert
        Assert.assertEquals(TurnNumberSequence.VIP_CUSTOMER_FIRST_NUMBER, ticket.getTurnNumber());
    }

    @Test
    public void theNumberSequenceOfTheRegularCustomersStartsFrom2001() throws Exception {
        //Arrange
        TurnNumberSequence regularTurnNumberSequence = new TurnNumberSequence(TurnNumberSequence.REGULAR_CUSTOMER_FIRST_NUMBER);
        TicketDispenser regularCustomerTicketDispenser = new TicketDispenser(regularTurnNumberSequence);

        //Act
        TurnTicket ticket = regularCustomerTicketDispenser.getTurnTicket();

        //Assert
        Assert.assertEquals(TurnNumberSequence.REGULAR_CUSTOMER_FIRST_NUMBER, ticket.getTurnNumber());
    }
}
