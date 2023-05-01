package application;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Animal> animalLista;
    public static void main(String[] args) {
        animalLista = new ArrayList<Animal>();

        home();
    }

    public static void home() {
        System.out.println("\n\n========================");
        System.out.println("===BATALHA DE ANIMAIS===");
        System.out.println("========================");

        System.out.print("\nSELECIONE UMA OPÇÃO:\n\n");
        System.out.println("[1] Cadastrar novo animal");
        System.out.println("[2] Listar animais cadastrados");
        System.out.println("[3] CONFRONTAR ANIMAIS");

        System.out.println("\n[0] Encerrar Sessão");

        System.out.print("\nSUA RESPOSTA >>> ");
        int resposta = input.nextInt();

        switch (resposta) {
            case 0:
                System.out.println("=== SESSÃO ENCERRADA ===");
                System.exit(0);
                break;
            
            case 1:
                cadastro();
                break;
            case 2:
                listar();
            case 3:
                confronto();
                break;

            default:
                break;
        }
    }

    //CASE 1: CADASTRAR ANIMAIS
    public static void cadastro() {
        System.out.println("\n\n========================");
        System.out.println("===CADASTRO DE ANIMAL===");
        System.out.println("========================");

        input.nextLine(); //Solucionar buffer

        System.out.print("NOME DO ANIMAL.... ");
        String nome = input.nextLine();

        System.out.print("MASSA............. ");
        int massa = input.nextInt();

        System.out.print("FORÇA............. ");
        int forca = input.nextInt();

        Animal animal = new Animal(nome, massa, forca);
        animalLista.add(animal);

        System.out.println("\n=======ANIMAL CADASTRADO COM SUCESSO=======");

        home(); //Retornando para tela inicial
    }

    //CASE 2: LISTAR ANIMAIS CADASTRADOS
    public static void listar() {
        System.out.println("\n\n==================================");
        System.out.println("===LISTA DE ANIMAIS CADASTRADOS===");
        System.out.println("==================================");

        if(animalLista.size() > 0) {
            for(Animal a : animalLista) {
                System.out.println("\nID #" + a.getId() + a + "\n");
            }
        }
        else {
            System.out.println("\n=== NÃO HÁ ANIMAIS CADASTRADOS ===");
        }

        home();
    }

    //CASE 3: CONFRONTAR OS ANIMAIS CADASTRADOS
    public static void confronto() {
        System.out.println("\n\n==================================");
        System.out.println("=======CONFRONTO DE ANIMAIS=======");
        System.out.println("==================================\n");

        System.out.print("Digite o ID do Animal que irá ATACAR --> ");
        int idAnimal1 = input.nextInt();

        System.out.print("\nDigite o ID do Animal que será ATACADO --> ");
        int idAnimal2 = input.nextInt();

        Animal animal1 = encontrarAnimal(idAnimal1);
        Animal animal2 = encontrarAnimal(idAnimal2);

        if(animal1 != null && animal2 != null) {
            animal1.atacar(animal2);
            
            if(animal1.getVivo() && animal2.getVivo() == false ){
                System.out.println("\n" + animal2.getNome() + " Está morto :(");
            }

            else if(animal1.getVivo() && animal2.getVivo()){
            System.out.println(animal1.getNome() + " X " + animal2.getNome());
            System.out.println("\n>>> " + animal1.getNome() + " CAUSOU " + animal1.getForca() + " de dano no " + animal2.getNome());

            System.out.println(animal1.getNome() + " --> " + animal1.getHp() + "% de vida");
            System.out.println(animal2.getNome() + " --> " + animal2.getHp() + "% de vida");
            }
            }

        else{
            System.out.println("\n=========UM OU AMBOS ANIMAIS NÃO ENCONTRADOS=========");
        }

        home();
    }

    //Algortimo para encontrar os animais
    public static Animal encontrarAnimal(int id) {

        Animal animal_ene = null;

        if(animalLista.size() > 0) {
            for(Animal a : animalLista) {
                if(a.getId() == id ) {
                    animal_ene = a;
                    break;
                }
            }
        }
    return animal_ene;  
    }  
}
