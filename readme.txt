javac com/mkyong/client/HttpsClient.java


Add on local

java com.mkyong.client.HttpsClient "https://www.google.com/"
java com.mkyong.client.HttpsClient "https://dth298067l:7002/console/login/LoginForm.jsp"

java -Djavax.net.debug=ssl com.mkyong.client.HttpsClient

java -Djavax.net.ssl.keyStorePassword=changeit  -Djavax.net.ssl.trustStorePassword=changeit com.mkyong.client.HttpsClient


javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException:PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderExce
ption: unable to find valid certification path to requested target



http://stackoverflow.com/questions/2893819/telling-java-to-accept-self-signed-ssl-certificate
http://stackoverflow.com/questions/6340918/trust-store-vs-key-store-creating-with-keytool
http://www.herongyang.com/JDK/SSL-Socket-Make-Self-Signed-Certificates-Trusted.html


-Djavax.net.debug=ssl
-Djavax.net.ssl.keyStoreType=pkcs12
-Djavax.net.ssl.keyStore=client.p12
-Djavax.net.ssl.keyStorePassword=whatever
-Djavax.net.ssl.trustStoreType=jks
-Djavax.net.ssl.trustStore=client-truststore.jks
-Djavax.net.ssl.trustStorePassword=whatever



keytool -import -v -trustcacerts -alias server-alias -file server.cer -keystore cacerts.jks -keypass changeit -storepass changeit 

keytool -import -v -trustcacerts -alias localweblogic  -file "/d/Source Code/JavaHttpsClient/cerFromWebLogic.cer"  -keystore "/c/Program Files (x86)/Java/jre6/lib/security/cacerts" -keypass changeit -storepass changeit       // �ѹ������ѹ��� work ��͹˹�ҹ������������� env PATH �ѹ�� jre6 �����͹����� �͹���¡ java ����¡� path ��� �����͹���¡ javac ��ѧ path \jdk1.6.0_45  ����駧


C:\Program Files (x86)\Java\jre6\lib\security

keytool -importcert -alias localweblogic -file "/d/Source Code/JavaHttpsClient/cerFromWebLogic.cer"   ���� ����� run �ѹ�������� password �ͧ File keystore ��� changeit �ͧ���� ���ǵͺ yes �ա��


git remote add origin https://github.com/freeseed/JavaHttpsClient


******* ��ػ��鹵͹��� ********
1. ŧ Weblogic �µ�ͧ����¹ location �� America �֧��ŧ��ҹ �͹���ŧ�����  C:\oracle\Middleware\wlserver_10.3 �¨��Ҿ���� Self-signed Certificate �������
2. �� Chrome Access ˹���á����� https https://dth298067l:7002/console/login/LoginForm.jsp  ���� Export Certificate �͡�� ���� Chrome Save �� XXXX.cer
�ӡ�� import XXXX.cer �����ѧ Default C:\Program Files (x86)\Java\jre6\lib\security\cacerts  ����� ��� default ���ǹ������ �� Certificate �ͧ CA �ѧ���������
㹵�����ҧ����繡�����ҧ file trustcert ���� �ѹ������� Certificate �ͧ CA �ѧ�����
3. �ͧ���ҧ Client ������к�




--Java HTTPS client certificate authentication
