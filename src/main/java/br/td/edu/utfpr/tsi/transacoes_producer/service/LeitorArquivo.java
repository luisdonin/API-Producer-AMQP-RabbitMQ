package br.td.edu.utfpr.tsi.transacoes_producer.producer;

import br.td.edu.utfpr.tsi.transacoes_producer.model.Transacao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    public List<Transacao> lerArquivo(){
        List<Transacao> transacoes = new ArrayList<Transacao>();
        try{
            Reader leitorArquivo = new FileReader("/home/donin/Documents/Trabalho 2 - Java/transacoes.producer/src/main/java/br/td/edu/utfpr/tsi/transacoes_producer/producer/transacoes.csv");
            CSVFormat configCSV = CSVFormat.Builder.create().setHeader("codigo", "cedente", "pagador", "valor", "vencimento").setSkipHeaderRecord(true).build();
            CSVParser interpretadorCSV = configCSV.parse(leitorArquivo);
            List<CSVRecord> records = interpretadorCSV.getRecords();

            for (CSVRecord record : records){
                String codigo = record.get("codigo");
                String cedente = record.get("cedente");
                String pagador = record.get("pagador");
                Double valor = Double.valueOf(record.get("valor"));
                String vencimento  = record.get("vencimento");


                Transacao t = new Transacao(codigo, cedente, pagador, valor, vencimento);
                transacoes.add(t);
            }

        } catch (IOException e){
            System.out.println("Erro ao abrir o arquivo  CSV");
        }
        return transacoes;
    }

                

}
