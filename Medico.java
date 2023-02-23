package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;



    @Table(name = "medicos")
    @Entity(name = "Medico")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of="id")
    public class Medico {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String crm;
        //private String telefone;

        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;

        @Embedded
        private Endereco endereco;



        public Medico(DadosCadastroMedico dados) {

            this.nome = dados.nome();
            this.email = dados.email();
            this.crm = dados.crm();
            this.especialidade = dados.especialidade();
            this.endereco = new Endereco(dados.endereco());
            //this.telefone = dados.telefone();
        }

        public void atualizarInformacoes(DadosAtualizacaoMedicos dados) {
            if (dados.nome() != null ){
                this.nome = dados.nome();
            }
            if (dados.endereco() != null){
                this.endereco.atualizarInformacoes(dados.endereco());
            }

        }
    }


