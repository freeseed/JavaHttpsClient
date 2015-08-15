javac com/mkyong/client/HttpsClient.java
--Add this in remote

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

keytool -import -v -trustcacerts -alias localweblogic  -file "/d/Source Code/JavaHttpsClient/cerFromWebLogic.cer"  -keystore "/c/Program Files (x86)/Java/jre6/lib/security/cacerts" -keypass changeit -storepass changeit       // ÍÑ¹¹Õé¤×ÍÍÑ¹·Õè work ¡èÍ¹Ë¹éÒ¹ÕéãªéäÁèä´éà¾ÃÒÐ env PATH ´Ñ¹ÁÕ jre6 ÍÂÙè¡èÍ¹·ÓãËé µÍ¹àÃÕÂ¡ java ä»àÃÕÂ¡ã¹ path ¹Ñé¹ áÅÐáµèµÍ¹àÃÕÂ¡ javac ä»ÂÑ§ path \jdk1.6.0_45  ·ÓãËé§§


C:\Program Files (x86)\Java\jre6\lib\security

keytool -importcert -alias localweblogic -file "/d/Source Code/JavaHttpsClient/cerFromWebLogic.cer"   ãªéä´é àÁ×èÍ run ÁÑ¹¨ÐãËéãÊè password ¢Í§ File keystore ¤×Í changeit ÊÍ§¤ÃÑé§ áÅéÇµÍº yes ÍÕ¡·Õ


git remote add origin https://github.com/freeseed/JavaHttpsClient


******* ÊÃØ»¢Öé¹µÍ¹¡ÒÃ ********
1. Å§ Weblogic â´ÂµéÍ§à»ÅÕèÂ¹ location à»ç¹ America ¶Ö§¨ÐÅ§¼èÒ¹ µÍ¹¹ÕéÅ§äÇé·Õè  C:\oracle\Middleware\wlserver_10.3 â´Â¨ÐÁÒ¾ÃéÍÁ Self-signed Certificate äÇéáÅéÇ
2. ãªé Chrome Access Ë¹éÒáÃ¡·Õèà»ç¹ https https://dth298067l:7002/console/login/LoginForm.jsp  áÅéÇ Export Certificate ÍÍ¡ÁÒ â´Âãªé Chrome Save à»ç¹ XXXX.cer
·Ó¡ÒÃ import XXXX.cer à¢éÒä»ÂÑ§ Default C:\Program Files (x86)\Java\jre6\lib\security\cacerts  ·Õèà»ç¹ µÑÇ default ãªéµÑÇ¹Õéà¾ÃÒÐ ÁÕ Certificate ¢Í§ CA ´Ñ§æÍÂÙèáÅéÇ
ã¹µÑÇÍÂèÒ§¶éÒà»ç¹¡ÒÃÊÃéÒ§ file trustcert ãËÁè ÁÑ¹¨ÐäÁèÁÕ Certificate ¢Í§ CA ´Ñ§æÍÂÙè
3. ÅÍ§ÊÃéÒ§ Client â´ÂãËéÃÐºØ




--Java HTTPS client certificate authentication
