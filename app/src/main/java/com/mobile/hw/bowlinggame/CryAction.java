package com.mobile.hw.bowlinggame;

/**
 * Created with Android Studio.
 * User: ihaiwen
 * Date: 7/22/15
 * Time: 4:36 PM
 * <p/>
 * TODO: Add a header comment!
 */

public class CryAction extends Action{
    public void doThings(Grandfather grandfather) {
//        grandfather.doThings();
        System.out.println("grandfather do cry");
    }

    public void doThings(Father father) {
//        father.doThings();
        System.out.println("father do cry");
    }

    public void doThings(Son son) {
//        son.doThings();
        System.out.println("son do cry");
    }
}
