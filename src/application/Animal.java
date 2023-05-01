package application;

public class Animal {
    private static int qntAnimais = 1;
    private int id = 1;
    private boolean vivo;
    private int hp;
    private int massa;
    private int posicaoX; //Atributos para mobilidade do Animal
    private int forca;
    private String nome;
    
    //Método Construtor
    public Animal(){}

    public Animal(String nome, int massa, int forca) {
        this.id = qntAnimais;
        this.nome = nome;
        this.vivo = true;
        this.massa = massa;
        this.forca = forca;
        this.hp = 100;
        qntAnimais++;

        this.posicaoX = 0;
    }

    public void comer(int massa) {
        this.massa += massa;
    }

    public void mover(int deslocamento) {
        if(this.vivo == true) {
            this.posicaoX += deslocamento;
        }

        else {
            System.out.print("Animal morto");
        }
    }

    public String toString() {
        return
        "\nNOME........... " + getNome() +
        "\nSITUAÇÃO....... " + (getVivo() ? "Vivo" : "Morto") +
        "\nMASSA.......... " + getMassa() +
        "\nFORÇA.......... " + getForca() +
        "\nPOSIÇÃO........ " + getX() +
        "\nHP............. " + getHp() + "%";


    }

    //SETs e GETs

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setHp(int hp) {
        if(hp > 100) {
            this.hp = 100;
        }
        else if(hp <= 0) {
            this.hp = 0;
            this.setVivo(false);
        }
        else {
            this.hp = hp;
        }
    }

    public int getHp() {
        return this.hp;
    }

    public void setVivo(boolean vitalidade) {
        this.vivo = vitalidade;
    }

    public boolean getVivo() {
        return this.vivo;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public int getMassa() {
        return this.massa;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getForca() {
        return this.forca;
    }

    public void setX(int x) {
        this.posicaoX = x;
    }

    public int getX() {
        return this.posicaoX;
    }
    //////////////////////////////
    // AÇÕES:

    //Quando o animal "a" ser atacado, seu HP será subtraido pelo valor da força do atacante
    public void atacar(Animal a) {

        if(this.vivo && a.vivo){
            a.setHp(a.getHp() - this.forca);
            
        }
        else {
            System.out.printf("\n\n--AÇÃO IMPOSSIBILITADA--\nAnimal atacante --> %s\nAnimal atacado --> %s\n\n", this.getVivo() ? "Vivo" : "Morto", a.getVivo() ? "Vivo" : "Morto");
        }
    }
    
}
