package oop.exception;

// 사용자 정의 예외
// - 직접 만든 예외 클래스는 Exception 또는 RuntimeException을 상속할 수 있다.
// - throw는 예외를 발생시키고, throws는 메소드가 예외를 전달할 수 있음을 선언한다.

public class CustomExceptionExample {

    // 예약 가능한 좌석이 부족할 때 사용할 예외
    static class SeatsUnavailableException extends Exception {

        public SeatsUnavailableException() {
            super("예약 가능한 좌석이 부족합니다.");
        }

        public SeatsUnavailableException(String message) {
            super(message);
        }
    }

    static class Theater {
        private int availableSeats = 3;

        public void reserve(int count) throws SeatsUnavailableException {
            if (count <= 0) {
                throw new IllegalArgumentException("예약 인원은 1명 이상이어야 합니다.");
            }

            if (count > availableSeats) {
                throw new SeatsUnavailableException(
                        "남은 좌석: " + availableSeats + "석, 요청 좌석: " + count + "석"
                );
            }

            availableSeats -= count;
            System.out.println(count + "석 예약 완료");
        }

        public int getAvailableSeats() {
            return availableSeats;
        }
    }

    public static void main(String[] args) {
        Theater theater = new Theater();

        try {
            theater.reserve(2);
            theater.reserve(2);
        } catch (SeatsUnavailableException e) {
            System.out.println("예약 실패: " + e.getMessage());
        }

        System.out.println("남은 좌석: " + theater.getAvailableSeats() + "석");
    }
}