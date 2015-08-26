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

    //TODO-user-intent-test-working-on: a new ticket should have the turn number subsequent to the previous ticket from another dispenser
    @Test
    public void aNewTicketShouldHaveTheTurnNumberSubsequentToThePreviousTicketFromAnotherDispenser() throws Exception {
        //Assert
        Assert.assertEquals(1, (newTicket.getTurnNumber() - previousTicket.getTurnNumber()));
    }

    //TODO-unit-test: the ticket dispenser should dispense the ticket number 11 if give a turn number 11 to it
    //TODO-new-feature: the turn number sequence of the vip customers starts from 1001
    //TODO-new-feature: the turn number sequence of the regular customers starts from 2001
}
