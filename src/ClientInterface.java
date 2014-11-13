import java.io.IOException;
import java.net.Socket;

/**
 * Created by Quentin on 13/11/14.
 */
public interface ClientInterface {

    Socket createClient(String clientName, int portNumber) throws IOException;

    Request addNameNickname(String name, String nickname);

    Request printNameNickname();

}
