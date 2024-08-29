import javax.swing.*; // Swing 라이브러리를 사용하여 GUI 컴포넌트를 만들기 위해 사용
import java.awt.Dimension; // 그래픽 요소의 크기를 정의하기 위해 사용
import java.awt.Toolkit; // 시스템의 다양한 정보를 얻기 위한 클래스

public class App1 {
    public static void main(String[] args) { 
    // Java 프로그램의 시작점인 main 메소드 정의
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        // GUI 관련 코드를 Swing 스레드에서 실행하기 위해 사용 -> 스레드 안전성 보장
            public void run() {
                JFrame frame = new JFrame("Hellow WOOD?");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // setDefaultCloseOperation: 창을 닫을 때 애플리케이션을 종료하도록 설정
                frame.setPreferredSize(new Dimension(400, 300)); // 앱 사이즈 
                
                JLabel label = new JLabel("START JAVA", SwingConstants.CENTER);
                frame.getContentPane().add(label); // add: 생성한 레이블을 JFrame의 콘텐츠 팬에 추가
                
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
                // `dim`은 `Toolkit.getDefaultToolkit().getScreenSize()`로 가져온 현재 화면의 크기를 나타냄 
                frame.setLocation(dim.width/2-499/2, dim.height/2-300/2); // 화면에 띄울 앱 위치 지정(현재 중앙)

                frame.pack(); // pack: 컴포넌트의 크기를 자동으로 조정하여 최적 크기로 조정
                frame.setVisible(true); // setVisible(true): JFrame을 화면에 표시
            }
        });
    }
}