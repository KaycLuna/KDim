package com.example.kdim.database;



public class ScriptDDL {


    public static String getCreateTabletipoaços(){

    StringBuilder sql = new StringBuilder();


       sql.append( "CREATE TABLE IF NOT EXISTS tipodeaços (");
       sql.append(" nome VARCHAR (100) PRIMARY KEY NOT NULL,");
       sql.append("fu   DOUBLE        NOT NULL,");
       sql.append("fy   DOUBLE        NOT NULL)");

       return sql.toString();}

        public static String gravardadostipoaço(){
            StringBuilder sqlgravar = new StringBuilder();

            sqlgravar.append(" INTO IF NOT EXISTS tipodeaços (nome, fu, fy)");
            sqlgravar.append(" ASTM A 572 Grau 50, 450,345);");
            sqlgravar.append("VALUES ASTM A 572 Grau 60*, 520,415);");
            sqlgravar.append("VALUES ASTM A 992*, 450,345);");
            sqlgravar.append("VALUES AÇO COR 500*, 500,370);");
            sqlgravar.append("VALUES ASTM A 131 AH32*, 590,315);");
            sqlgravar.append(" VALUES ASTM A 131 AH36*, 620,355);");

            return sqlgravar.toString();

        }


        }





