# Informações importantes

1 - Banco de dados MYSQL local!

Crie seu banco utilizando o XAMPP ou MYSQL Workbench 
e crie o banco com nome "ddd_pokemon"

Após, crie a tabela "pokemon" com o código a seguir:
```mysql
create table pokemon (
    codigo int not null AUTO_INCREMENT PRIMARY KEY ,
    nome varchar(100) not null,
    altura double not null,
    categoria varchar(1000) not null, 
    peso double not null, 
    data_da_captura date not null
);
```
Após, crie alguns inserts para utilizarmos de teste depois, como os inserts a seguir:
```mysql
insert into pokemon(altura, nome, categoria, data_da_captura, peso) values (
    1.67, 
    'Lucario',
    'Lutador/Aço',
    DATE('2024-10-07'),
    45.50
);
```
E agora o Pikachu, por que não?
```mysql
insert into pokemon(altura, nome, categoria, data_da_captura, peso) values (
    1.10, 
    'Pikachu',
    'Elétrico',
    DATE('2024-10-07'),
    15.50
);
```

Após criar, suba o projeto usando a classe Main dentro do caminho `src/main/java/Main.java`

Depois se diverta com o Postman (melhor que aquele estranho do Imsonia)

Erro? Sugestão de melhora? Me manda uma mensagem no meu [Linkedin](https://linkedin.com/in/gustavodiasdsc)!