insert into course( id, name, last_updated_date, created_date ) values( 10001, 'Java Como Programar', sysdate(), sysdate());
insert into course( id, name, last_updated_date, created_date ) values( 10002, 'C# Como Programar', sysdate(), sysdate());
insert into course( id, name, last_updated_date, created_date ) values( 10003, 'HTML5 Como Programar', sysdate(), sysdate());

insert into passport( id, number )values( 30001, 'E123456' );  
insert into passport( id, number )values( 30002, 'N123456' );
insert into passport( id, number )values( 30003, 'J123456' );

insert into student( id, name, passport_id )values( 20001, 'Cristiano', 30001 ); 
insert into student( id, name, passport_id )values( 20002, 'Silvio', 30002  );
insert into student( id, name, passport_id )values( 20003, 'Vanessa', 30003  );

insert into reviews( id, rating, description )values( 40001, '5', 'Awesome' );
insert into reviews( id, rating, description )values( 40002, '4', 'Bad' );
insert into reviews( id, rating, description )values( 40003, '3', 'Greatfull' );