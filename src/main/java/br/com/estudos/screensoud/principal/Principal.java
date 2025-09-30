package br.com.estudos.screensoud.principal;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {

        var opcao = -1;

        while(opcao != 9){
            var menu = """
                    1 - Cadastrar Artista
                    2 - Cadastrar Musicas
                    3 - Listar Musicas
                    4 - Buscar musicas por Artistas
                    5 - Pesquisar dados sobre um artistar
                    
                    9 - Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch ( opcao) {
                case 1:
                    cadastarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a Aplicacao!");
                    break;
                default:
                    System.out.println("Opcao Invalida!");

            }

        }
    }

    private void pesquisarDadosDoArtista() {
    }

    private void buscarMusicaPorArtista() {
    }

    private void listarMusicas() {
    }

    private void cadastrarMusicas() {
    }

    private void cadastarArtistas() {
    }
}
