javac com/mkyong/client/HttpsClient.java


java com.mkyong.client.HttpsClient

java -Djavax.net.debug=ssl com.mkyong.client.HttpsClient

java -Djavax.net.ssl.keyStorePassword=changeit  -Djavax.net.ssl.trustStorePassword=changeit com.mkyong.client.HttpsClient


javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException:PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderExce
ption: unable to find valid certification path to requested target



http://stackoverflow.com/questions/2893819/telling-java-to-accept-self-signed-ssl-certificate
http://stackoverflow.com/questions/6340918/trust-store-vs-key-store-creating-with-keytool


-Djavax.net.debug=ssl
-Djavax.net.ssl.keyStoreType=pkcs12
-Djavax.net.ssl.keyStore=client.p12
-Djavax.net.ssl.keyStorePassword=whatever
-Djavax.net.ssl.trustStoreType=jks
-Djavax.net.ssl.trustStore=client-truststore.jks
-Djavax.net.ssl.trustStorePassword=whatever



keytool -import -v -trustcacerts -alias server-alias -file server.cer -keystore cacerts.jks -keypass changeit -storepass changeit 

keytool -import -v -trustcacerts -alias localweblogic  -file "/d/Source Code/JavaHttpsClient/cerFromWebLogic.cer"  -keystore "/c/Program Files (x86)/Java/jre6/lib/security/cacerts" -keypass changeit -storepass changeit       // อันนี้คืออันที่ work ก่อนหน้านี้ใช้ไม่ได้เพราะ env PATH ดันมี jre6 อยู่ก่อนทำให้ ตอนเรียก java ไปเรียกใน path นั้น และแต่ตอนเรียก javac ไปยัง path \jdk1.6.0_45  ทำให้งง


C:\Program Files (x86)\Java\jre6\lib\security

keytool -importcert -alias localweblogic -file "/d/Source Code/JavaHttpsClient/cerFromWebLogic.cer"   ใช้ได้ เมื่อ run มันจะให้ใส่ password ของ File keystore คือ changeit สองครั้ง แล้วตอบ yes อีกที