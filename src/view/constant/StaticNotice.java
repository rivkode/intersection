package view.constant;

public enum StaticNotice {
    GAME_START("지금부터 교차로 검증을 시작합니다. \n"),
    CHOOSE_TYPE("원하는 데이터셋을 입력해주세요. \n"),
    POINT_LIST("검증에 사용된 포인트 리스트입니다. \n"),
    GAME_END("수고하셨습니다. 교차로 검증이 끝났습니다.")
    ;
    private final String message;

    StaticNotice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
