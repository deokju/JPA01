package jpastart.main;

import jpastart.jpa.EMF;
import jpastart.reserve.application.DuplicateEmailException;
import jpastart.reserve.application.GetUserService;
import jpastart.reserve.application.JoinService;
import jpastart.reserve.model.User;
import sun.plugin2.message.GetAppletMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Optional;

public class UserMain {
    private static JoinService    joinService    = new JoinService();
    private static GetUserService getUserService = new GetUserService();

    public static void main(String[] args) throws IOException {
        EMF.init();

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );

        while( true ) {
            System.out.println("명령어를 입력하세요:");
            String line = reader.readLine();
            String[] commands = line.split(" ");
            if( commands[0].equalsIgnoreCase("exit") ) {
                System.out.println("종료합니다.");
                break;
            }
            else if( commands[0].equalsIgnoreCase("join") ) {
                handleJoinCommand(commands);
            }
            else if( commands[0].equalsIgnoreCase("view") ) {
                handleViewCommand(commands);
            }
            else if( commands[0].equalsIgnoreCase("list") ) {
            }
            else if( commands[0].equalsIgnoreCase("changename") ) {

            }
            else if( commands[0].equalsIgnoreCase("withdraw") ) {
            }
            else {
                System.out.println("올바른 명령어를 입력하세요.");
            }

            System.out.println("---------");
        }

        EMF.close();
    }

    private static void handleJoinCommand(String[] cmd) {
        if(cmd.length != 3) {
            System.out.println("명령어가 올바르지 않습니다.");
            System.out.println("사용법:join 이메일 이름");
            return;
        }
        try{
            joinService.join(new User( cmd[1], cmd[2], new Date() ) );
            System.out.println("가입 요청을 처리했습니다.");
        }catch(DuplicateEmailException e){
            System.out.println("이미 같은 이메일을 가진 사용자가 존재합니다.");
        }
    }

    private static void handleViewCommand(String[] cmd) {
        if(cmd.length != 2) {
            System.out.println("명령어가 올바르지 않습니다.");
            System.out.println("사용법:view 이메일");
            return;
        }

        Optional<User> userOpt = getUserService.getUser(cmd[1]);

        if(userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("이름:" + user.getName());
            System.out.printf("생성 : %tY-%<tm-%<td\n", user.getCreateDate());
        }else{
            System.out.println("존재하지 않습니다.");
        }
    }
}
