package com.example.thamirysrsantos.todo.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//Definição no nome da classe ControlaBanco. Segue o padrão de nome: classe começam com a primeira letra maiúscula
public class ControlaBanco {

    //Declaração do objeto db do tipo "SQLiteDataBase"
    private SQLiteDatabase db;

    //Declaração do objeto "banco" do tipo "CriaBanco". Obejto privado -> só pode ser acessado pela classe atual
    private CriaBanco banco;

    //Construtor da classe. Recebe como parâmetro o contexto. Publico -> pose ser acessado fora da classe atual
    public ControlaBanco(Context context) {
        banco = new CriaBanco(context);
    }

    //Método do tipo String (deve ser retornado um valor em String)
    //Público -> pode ser acsseado fora da classe
    //Recebe como parâmentro uma variável do tipo String
    public String insereDado(String nome) {

        //Declara o objeto tipo "valores" do tipo "ContentValues"
        //Padrão de nome para objeto é começar com a primeira letra minúscula
        ContentValues valores;

        //Declara a variavel "resultado" do tipo "long"
        //Padrão de nome para variavel é começar com a primeira letra minúscula
        long resultado;

        //Retorna o valor do método "getWritableDataBase" e adiciona no objeto "db"
        //Diz que o banco está preparado para a escrita de novos dados
        db = banco.getWritableDatabase();

        //Instancia o objeto "valores" com o construtor de classe "ContentValues"
        valores = new ContentValues();

        //put é um método que recebe como parâmetro duas Strings
        // Primeira String é o nome da coluna no banco de dados
        //Segunda String é o dado que será inserido na linha
        valores.put("nome", nome);

        //insert é um método que recebe como parâmetro três valores
        //Primeiro valor é uma String com o nome da tabela
        //Segundo valor é uma String para os campos nulos
        //Terceiro valor é um objeto do tipo "ContentValues" com o valor a ser inserido
        //método retorna o valor na variável resultado
        resultado = db.insert("tarefa", null, valores);

        //close é um método fechar que não recebe nenhum parâmetro
        db.close();


        if (resultado == -1) {
            return "Erro ao inserir dado";
        } else {
            return "Dado inserido com sucesso";
        }
    }

    //Declarando um método público do tipo Cursor que não recebe nenhum parâmetro
    public Cursor carregaDados() {
        //Objeto "cursor" do tipo "Cursor"
        Cursor cursor;
        //Um array de Strings com o nome "campos" que recebe os valores entre as chaves
        String[] campos = {"_id", "nome"};
        //getReadableDataBase é um método do objeto "banco" que retorna um valor para o objeto "db"
        //Esse método diz que o banco estará disponivel para leitura
        db = banco.getReadableDatabase();
        //query é um método do objeto db que recebe como parâmetro o que está entre os parâmetros
        //o valor retornado do método query está inserido no objeto cursor
        cursor = db.query("tarefa", campos, null, null, null, null, null);

        //Compara se ocursor não é nulo(vázio)
        if (cursor != null) {
            //coloca o cursor na primeira posição
            cursor.moveToFirst();
        }
        //método fechar
        db.close();
        //retorna ao objeto cursor
        return cursor;
    }

    public void deletaDado(int id) {
        String where = "_id = " + id;
        db = banco.getReadableDatabase();
        db.delete("tarefa", where, null);
        db.close();
    }

    public Cursor carregaDadoPorId(int id) {
        Cursor cursor;
        String[] campos = {"_id", "nome"};
        String where = "_id = " + id;
        db = banco.getReadableDatabase();
        cursor = db.query("tabela", campos, where, null, null, null, null);

        if (cursor!=null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
