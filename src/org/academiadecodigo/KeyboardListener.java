package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class KeyboardListener {
    public KeyboardListener(Engine engine){

        Keyboard k = new Keyboard(engine);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventRight);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventLeft);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventDown);

        KeyboardEvent eventC = new KeyboardEvent();
        eventC.setKey(KeyboardEvent.KEY_C);
        eventC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventC);

        KeyboardEvent eventV = new KeyboardEvent();
        eventV.setKey(KeyboardEvent.KEY_V);
        eventV.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventV);

        KeyboardEvent eventR = new KeyboardEvent();
        eventR.setKey(KeyboardEvent.KEY_R);
        eventR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventR);

        KeyboardEvent eventS = new KeyboardEvent();
        eventS.setKey(KeyboardEvent.KEY_S);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventS);

        KeyboardEvent eventL = new KeyboardEvent();
        eventL.setKey(KeyboardEvent.KEY_L);
        eventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventL);
    }
}
