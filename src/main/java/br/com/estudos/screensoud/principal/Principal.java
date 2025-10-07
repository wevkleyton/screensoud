package br.com.estudos.screensoud.principal;

import br.com.estudos.screensoud.model.Artista;
import br.com.estudos.screensoud.model.Musica;
import br.com.estudos.screensoud.model.TipoArtista;
import br.com.estudos.screensoud.repository.ArtistaRepository;
import br.com.estudos.screensoud.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);



    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

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
        System.out.println("Pesquisar dados sobre qual artista? ");
        var nome = leitura.nextLine();
        var resposta = ConsultaChatGPT.obterInformacao(nome);
        System.out.println(resposta.trim());
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Buscar musicas de que artista? ");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscaMusicasPorArtista(nome);
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar musica de que artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome); // utilizacao de derivad quary
        if (artista.isPresent()){
            System.out.println("Informe o titulo da musica: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        }else{
            System.out.println("Artista nao encontrado!");
        }

    }

    private void cadastarArtistas() {

        String casdastrarNovo = "S";

        while (casdastrarNovo.equalsIgnoreCase("s")){
        System.out.println("Informe o nome do Artista: ");
        var nome = leitura.nextLine();
        System.out.println("Inrome o tipo desse artista: (solo, dupla ou banda) ");
        var tipo = leitura.nextLine();
        TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
        Artista artista = new Artista( nome, tipoArtista);
        repositorio.save(artista);
        System.out.println("Cadastrar novo artista ? (S/N) ");
        casdastrarNovo = leitura.nextLine();
        }

    }
}
