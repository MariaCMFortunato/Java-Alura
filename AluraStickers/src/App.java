import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /*Obter os dados do site IMBD:
            * Fazer ma conexão htpp(protocolo web)
            * Obter os dados do site IMD dos top 250 filmes */
        String url = "https://imdb-api.com/en/API/Top250Movies/k_iuznk535";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        // OU:var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        // OU:HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        //client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        /*Extrair (parsear) apenas os dados qe interessam:
            * Título
            * Imagem (poster)
            * Classificação */
        JsonParser parser = new JsonParser();
        //OU: var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());
        /*Exibir e manipular os dados */


    }
}
