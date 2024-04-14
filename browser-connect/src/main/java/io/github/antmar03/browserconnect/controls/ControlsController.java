package io.github.antmar03.browserconnect.controls;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.event.InputEvent;
import static java.awt.event.KeyEvent.*;


@RestController
@RequestMapping("/controls")
public class ControlsController {
    private void pressKey(int keyEvent) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(keyEvent);
    }

    private void setMousePos(int x, int y) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }


    @GetMapping(value = "/press/{key}")
    @CrossOrigin
    public void pressKey(@PathVariable(value="key") String key) throws AWTException {
        switch (key) {
            case "a": pressKey(VK_A); break;
            case "b": pressKey(VK_B); break;
            case "c": pressKey(VK_C); break;
            case "d": pressKey(VK_D); break;
            case "e": pressKey(VK_E); break;
            case "f": pressKey(VK_F); break;
            case "g": pressKey(VK_G); break;
            case "h": pressKey(VK_H); break;
            case "i": pressKey(VK_I); break;
            case "j": pressKey(VK_J); break;
            case "k": pressKey(VK_K); break;
            case "l": pressKey(VK_L); break;
            case "m": pressKey(VK_M); break;
            case "n": pressKey(VK_N); break;
            case "o": pressKey(VK_O); break;
            case "p": pressKey(VK_P); break;
            case "q": pressKey(VK_Q); break;
            case "r": pressKey(VK_R); break;
            case "s": pressKey(VK_S); break;
            case "t": pressKey(VK_T); break;
            case "u": pressKey(VK_U); break;
            case "v": pressKey(VK_V); break;
            case "w": pressKey(VK_W); break;
            case "x": pressKey(VK_X); break;
            case "y": pressKey(VK_Y); break;
            case "z": pressKey(VK_Z); break;
            case "`": pressKey(VK_BACK_QUOTE); break;
            case "0": pressKey(VK_0); break;
            case "1": pressKey(VK_1); break;
            case "2": pressKey(VK_2); break;
            case "3": pressKey(VK_3); break;
            case "4": pressKey(VK_4); break;
            case "5": pressKey(VK_5); break;
            case "6": pressKey(VK_6); break;
            case "7": pressKey(VK_7); break;
            case "8": pressKey(VK_8); break;
            case "9": pressKey(VK_9); break;
            case "-": pressKey(VK_MINUS); break;
            case "=": pressKey(VK_EQUALS); break;
            case "!": pressKey(VK_EXCLAMATION_MARK); break;
            case "@": pressKey(VK_AT); break;
            case "#": pressKey(VK_NUMBER_SIGN); break;
            case "$": pressKey(VK_DOLLAR); break;
            case "^": pressKey(VK_CIRCUMFLEX); break;
            case "&": pressKey(VK_AMPERSAND); break;
            case "*": pressKey(VK_ASTERISK); break;
            case "(": pressKey(VK_LEFT_PARENTHESIS); break;
            case ")": pressKey(VK_RIGHT_PARENTHESIS); break;
            case "_": pressKey(VK_UNDERSCORE); break;
            case "+": pressKey(VK_PLUS); break;
            case "\t": pressKey(VK_TAB); break;
            case "\n": pressKey(VK_ENTER); break;
            case "[": pressKey(VK_OPEN_BRACKET); break;
            case "]": pressKey(VK_CLOSE_BRACKET); break;
            case "\\": pressKey(VK_BACK_SLASH); break;
            case ";": pressKey(VK_SEMICOLON); break;
            case ":": pressKey(VK_COLON); break;
            case "\'": pressKey(VK_QUOTE); break;
            case "\"": pressKey(VK_QUOTEDBL); break;
            case ",": pressKey(VK_COMMA); break;
            case "Period": pressKey(VK_PERIOD); break;
            case "/": pressKey(VK_SLASH); break;
            case "Space": pressKey(VK_SPACE); break;
            case "Backspace": pressKey(VK_BACK_SPACE); break;
            case "ArrowUp": pressKey(VK_UP); break;
            case "ArrowDown": pressKey(VK_DOWN); break;
            case "ArrowLeft": pressKey(VK_LEFT); break;
            case "ArrowRight": pressKey(VK_RIGHT); break;

            default:
                throw new IllegalArgumentException("Cannot type character " + key);
        }
    }

    @GetMapping(value = "/mouse/{x}/{y}")
    @CrossOrigin
    public void moveMouse(@PathVariable(value="x") String x, @PathVariable(value="y") String y) throws AWTException {
        int xInt = Integer.parseInt(x);
        int yInt = Integer.parseInt(y);

        setMousePos(xInt, yInt);
    }

    @GetMapping(value = "/mouse/click")
    @CrossOrigin
    public void clickMouse() throws AWTException {
        System.out.println("click");
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
