package com.example.thamirysrsantos.todo.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Cria uma classe CriaBanco que herda da classe SQLiteOpenHelper
public class CriaBanco extends SQLiteOpenHelper {


    //Definição das constantes para nomes do banco, tabela e colunas
    private static final  String NOME_DE = "banco.db";
   private static final  String TABELA = "tarefa";
   private static final  String ID = "_id";
   private static final String NOME = "nome";
   private static final int VERSAO = 1;

   //Construtor da classe que recebe como parametro o contexto
   //Deve ser criado dessa forma pois a classe CriaBanco herda da classe SQLiteOpenHelper
   public CriaBanco(Context context) {
       super(context, NOME_DE, null, VERSAO);
   }

   //Anotação JAVA para sobreescrever um método herdado de uma classe
   @Override
   public void onCreate(SQLiteDatabase db) {
       //Cria uma String com um conteúdo de uma query(comando de SQL) para criar o banco de dados
       String sql = "CREATE TABLE " + TABELA + " ("
               + ID + " integer primary key autoincrement, "
               + NOME + " text"
               + ")";
       db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //Query para apagar a tabela
       String sql = "DROP TABLE IF EXISTS " + TABELA;
       db.execSQL(sql);
       //Chama o método onCreate novamento
       onCreate(db);

    }
}
