# stationery-ink
Distribute Sql base Streaming Aggregation Framework On Apache Storm

##Required System    
HBASE : 0.98.1-cdh5.1.3 above    
PHOENIX : 4.0.0-incubation (custom version) above    
STORM : 0.9.0.1 above    
REDIS    

##Ink features
1. SQL supported. (Tommy's SQL = TSQL)    
2. Esper integration.    
3. Launch Strom topology.    
4. Ink JDBC driver supported.    

##Ink Architecture
1. INK DAEMON : TSQL parsing and Execution DDL, DML query, generation storm topology base on TSQL, jdbc connector.  
2. INK JDBC DRIVER : INK's JDBC driver (type 2)  
3. INK DYNAMIC API : Rest api transported client to Aggerationed dataset by INK.  

![GitHub Logo](/ink.png)

##TSQL Commands
DDL TSQL :  
1. show cluster : Storm cluster current status infomation, topology information getting TSQL.  
2. show jobs | job JOB_NAME : job information stored in metastore getting TSQL.  
3. show streams | stream STREAM_NAME : stream information stored in metastore getting TSQL.  
4. show sources | source SOURCE_NAME : source information stored in metastore getting TSQL.  
5. drop job JOB_NAME : removing job stored in metastore TSQL.  
6. drop stream STREAM_NAME : removing stream stored in metastore TSQL.  
7. drop source SOURCE_NAME : removing source stored in metastore TSQL.  
8. kill job JOB_NAME : shutdown job in apache storm cluster TSQL.
9  snapshot job JOB_NAME : display resultset job executed to TSQL.  
 
DML TSQL:
1. select 쿼리 : esper의 EPL쿼리문법을 따름  
2. insert/ upsert/ upsert increase / delete / update 쿼리 : 일반적인 쿼리문법을 따름  
3. lookup 쿼리 : 해당 쿼리이전의 스트림에 lookup데이터를 붙여사용할때 사용하는 TSQL  
 
SET :  
1. set JOB_NAME='잡이름' : 쿼리에 해당 set이 있으면, 해당 쿼리를 스톰잡으로 구동시킴.  
2. set REGIST_JOB='Y' | 'N' : 쿼리에 해당 set이 있으면, 해당 쿼리문을 메타스토어에 JOB_NAME명으로 job을 저장함. (1번과 같이 사용 필수)   
3. set WORKER_CNT='숫자' : 쿼리에 해당 set이 있으면, 해당 스톰잡의 프로세스 갯수를 정의하여 구동시킴.  
4. set SPOUT_THREAD_CNT='숫자' : 쿼리에 해당 set이 있으면, spout에 해당하는 프로세스의 쓰레드 사용수를 정의하여 구동시킴.  
5. set ESPER_THREAD_CNT='숫자' : 쿼리에 해당 set이 있으면, esper에 해당하는 프로세스의 쓰레드 사용수를 정의하여 구동시킴.  
6. set LOOKUP_THREAD_CNT='숫자' : 쿼리에 해당 set이 있으면, lookup에 해당하는 프로세스의 쓰레드 사용수를 정의하여 구동시킴.  
7. set OUTPUT_THREAD_CNT='숫자' : 쿼리에 해당 set이 있으면, output에 해당하는 프로세스의 쓰레드 사용수를 정의하여 구동시킴.  
8. set IS_DEBUG='Y' | 'N' : 쿼리에 해당 set이 있으면, 디버그 모드로 잡을 구동시킴 (로그확인가능).  
9. set COMMIT_INTERVAL='숫자' : 쿼리에 해당 set이 있으면, output쿼리에서 해당 commit갯수로 커밋하여 저장함.  
10. set JOB_NAME='잡이름 : 쿼리에 해당 set이 있으면, 해당 잡이름이름으로 스톰잡을 구동시킴.  
