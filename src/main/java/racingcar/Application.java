package racingcar;

import racingcar.controller.GameController;
import racingcar.model.InputExtractor;
import racingcar.model.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new InputView(new InputValidator()),
                new OutputView(), new InputExtractor());
        gameController.start();
    }
}
