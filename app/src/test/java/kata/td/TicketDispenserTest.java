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

    //TODO-unit-test-working-on: the ticket dispenser should dispense the ticket number 11 if give a turn number 11 to it
    @Test
    public void theTicketDispenserShouldDispenseTheTicketNumber11IfGiveATurnNumber11ToIt() throws Exception {
        //Arrange
        TurnNumberSequence mockTurnNumberSequence = mock(TurnNumberSequence.class);
        when(mockTurnNumberSequence.getNextTurnNumber()).thenReturn(11);
        TicketDispenser ticketDispenser = new TicketDispenser(mockTurnNumberSequence);

        //Act
        TurnTicket ticket = ticketDispenser.getTurnTicket();

        //Assert
        Assert.assertEquals(11, ticket.getTurnNumber());
    }

    //TODO-new-feature: the turn number sequence of the vip customers starts from 1001
    //TODO-new-feature: the turn number sequence of the regular customers starts from 2001
}
