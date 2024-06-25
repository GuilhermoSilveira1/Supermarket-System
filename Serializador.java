import java.io.*;
import java.util.List;

public class Serializador {

    public void gravar(String fileName, List<?>... lists) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (List<?> list : lists) {
                oos.writeObject(list);
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<?>[] ler(String fileName) {
        List<?>[] lists = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            lists = new List[5]; // Assuming you have 5 lists
            for (int i = 0; i < 5; i++) {
                lists[i] = (List<?>) ois.readObject();
            }
            System.out.println("Dados carregados com sucesso!");
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
            System.out.println();
        }
        return lists;
    }
}
