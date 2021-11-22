# SECURITY-HOMEWORK
Resumen:
En este proyecto se creó una aplicación web de forma no segura y después se realiza el procedimiento para crear llaves públicas y privadas y un certificado utilizando formato PKCS12.
Ejecución de la aplicación:
--- exec-maven-plugin:3.0.0:exec (default-cli) @ securityapp ---
[Thread-0] INFO org.eclipse.jetty.util.log - Logging initialized @312ms to org.eclipse.jetty.util.log.Slf4jLog
[Thread-0] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - == Spark has ignited ...
[Thread-0] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - >> Listening on 0.0.0.0:4568
[Thread-0] INFO org.eclipse.jetty.server.Server - jetty-9.4.30.v20200611; built: 2020-06-11T12:34:51.929Z; git: 271836e4c1f4612f12b7bb13ef5a92a927634b0d; jvm 11.0.13+10-LTS-370
[Thread-0] INFO org.eclipse.jetty.server.session - DefaultSessionIdManager workerName=node0
[Thread-0] INFO org.eclipse.jetty.server.session - No SessionScavenger set, using defaults
[Thread-0] INFO org.eclipse.jetty.server.session - node0 Scavenging every 600000ms
[Thread-0] INFO org.eclipse.jetty.util.ssl.SslContextFactory - x509=X509@24d0de4b(ecikeypair,h=[],w=[]) for SslContextFactory@2109b922[provider=null,keyStore=file:///C:/Users/dtorres/Documents/otros/Maestria%20Informatica/Arquitectura%20y%20Gobernabilidad/javatutorial/securityapp/keystore/ecikeystore.p12,trustStore=null]
[Thread-0] INFO org.eclipse.jetty.server.AbstractConnector - Started ServerConnector@4eb931f5{SSL, (ssl, http/1.1)}{0.0.0.0:4568}
[Thread-0] INFO org.eclipse.jetty.server.Server - Started @1733ms 

 
Ejecución de la aplicación leyendo la URL de Google y de “hello world”, esta confía del certificado local creado. No confia en el certificado de google: 
--- exec-maven-plugin:3.0.0:exec (default-cli) @ securityapp ---
Transfer-Encoding:chunked
HTTP/1.1 200 OK
Server:Jetty(9.4.30.v20200611)
Date:Mon, 22 Nov 2021 04:02:28 GMT
Content-Type:text/html;charset=utf-8
Hello World
javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
------------------------------------------------------------------------
BUILD SUCCESS

Ejecución de la aplicación Ejecución de la aplicación leyendo la URL de Google y de “hello world”, confía el certificado de Google y no de la app creada:

--- exec-maven-plugin:3.0.0:exec (default-cli) @ securityapp ---
javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
Transfer-Encoding:chunked
HTTP/1.1 200 OK
Alt-Svc:h3=":443"; ma=2592000,h3-29=":443"; ma=2592000,h3-Q050=":443"; ma=2592000,h3-Q046=":443"; ma=2592000,h3-Q043=":443"; ma=2592000,quic=":443"; ma=2592000; v="46,43"
Server:gws
P3P:CP="This is not a P3P policy! See g.co/p3phelp for more info."
Date:Mon, 22 Nov 2021 04:51:46 GMT
Accept-Ranges:none
X-Frame-Options:SAMEORIGIN
Cache-Control:private, max-age=0
Vary:Accept-Encoding
Set-Cookie:NID=511=JH0c210PhjBw_uBLbpUqxnUz5KpCPye_8M__2HI0rfuZvG2qjhfuNbgTzFvUI5KOCLYP50oun6-2KVQrK1cp2CR7APJiywP6kHHx0igrLRBWN5J1x0LaNJSqfy5Fd-AlywkiHeBwyyKYM0uPswOT68PVNV1WCGMYVuDm5YkuV64; expires=Tue, 24-May-2022 04:51:46 GMT; path=/; domain=.google.com; HttpOnly1P_JAR=2021-11-22-04; expires=Wed, 22-Dec-2021 04:51:46 GMT; path=/; domain=.google.com; Secure
Expires:-1
X-XSS-Protection:0
Content-Type:text/html; charset=ISO-8859-1
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="es-419"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="92yW6FUvI/+QQ41FD86OeA==">(function(){window.google={kEI:'4iGbYcn-J9a1qtsP7OGUmA4',kEXPI:'0,202372,1100164,56873,1710,4348,207,4804,2316,383,246,5,1354,4012,1239,1122515,1197725,329542,51223,16115,28684,17572,4859,1361,9291,3028,17580,4020,978,13228,3847,4192,6430,21822,920,5080,1593,1279,2212,530,149,1103,840,1983,213,4101,3514,606,2023,1777,520,14670,3229,2844,7,5598,6755,5096,15767,554,907,2,941,15756,3,346,230,6460,148,12314,1661,4,1528,2304,7039,4683,18351,2039,2658,6701,654,32,11010,2618,1592,713,2132,16786,422,2100,3293,2542,4094,3140,6,906,3,3541,1,16524,283,912,5994,15329,2,3110,2,15953,3909,162,246,1272,743,5853,9454,1009,1160,1267,5433,2377,2721,14171,4126,2,6,2,7717,4568,2577,3124,286,265,1113,1363,1562,2,1,3,2594,3866,2,7583,545,2172,2020,2,596,437,5385,2,6,2,794,5453,195,2578,69,4678,2,1741,5,692,15,286,1253,874,4,2,497,1266,3,2,20,3,2,121,11,1632,901,222,261,905,454,494,83,32,3,965,27,99,53,65,463,511,189,4,45,31,369,110,2,2,1,332,864,2,209,852,749,443,1374,104,844,1369,35,3613,166,141,95,125,185,147,113,602,720,538,401,179,2,957,4,81,5,334,730,4,216,2,682,1236,779,891,2,2,7,2,2,5,2,4,2,10,3,1,990,455,526,111,258,744,127,6,2,14,311,24,2,404,224,5,705,391,1166,281,374,299,1591,497,5529342,101,345,314,134,30,6,5995865,519,212,2800485,882,444,1,2,80,1,1796,1,9,2553,1,748,141,795,563,1,4265,1,1,2,1331,4142,2609,155,17,13,72,139,4,2,20,2,169,13,19,46,5,39,96,548,29,2,2,1,2,1,2,2,7,4,1,2,2,2,2,2,2,353,513,186,1,1,158,3,2,2,2,2,2,4,2,3,3,269,551,478,304,133,4,71,10,8,11,1,7,3,20,10,3,19,23953090,4041351,338,3,2414,1008,483,9,1435,157,1360,1129,2,6061,620,112,832527',kBL:'YuPY'};google.sn='webhp';google.kHL='es-419';})();(function(){
(function(){google.jl={attn:false,blt:'none',chnk:0,dw:false,dwu:true,emtn:0,end:0,ine:false,lls:'default',pdt:0,rep:0,snet:true,strt:0,ubm:false,uwp:true};})();(function(){var pmc='{\x22d\x22:{},\x22sb_he\x22:{\x22agen\x22:false,\x22cgen\x22:false,\x22client\x22:\x22heirloom-hp\x22,\x22dh\x22:true,\x22dhqt\x22:true,\x22ds\x22:\x22\x22,\x22ffql\x22:\x22es\x22,\x22fl\x22:true,\x22host\x22:\x22google.com\x22,\x22isbh\x22:28,\x22jsonp\x22:true,\x22msgs\x22:{\x22cibl\x22:\x22Borrar búsqueda\x22,\x22dym\x22:\x22Quizás quisiste decir:\x22,\x22lcky\x22:\x22Me siento con suerte\x22,\x22lml\x22:\x22Más información\x22,\x22oskt\x22:\x22Herramientas de captura de texto\x22,\x22psrc\x22:\x22Se ha eliminado esta búsqueda de tu \\u003Ca href\x3d\\\x22/history\\\x22\\u003EHistorial web\\u003C/a\\u003E\x22,\x22psrl\x22:\x22Eliminar\x22,\x22sbit\x22:\x22Buscar por imágenes\x22,\x22srch\x22:\x22Buscar con Google\x22},\x22ovr\x22:{},\x22pq\x22:\x22\x22,\x22refpd\x22:true,\x22rfs\x22:[],\x22sbas\x22:\x220 3px 8px 0 rgba(0,0,0,0.2),0 0 0 1px rgba(0,0,0,0.08)\x22,\x22sbpl\x22:16,\x22sbpr\x22:16,\x22scd\x22:10,\x22stok\x22:\x22BinMyNHsI-PPcVGCFAb0CtGJw0c\x22,\x22uhde\x22:false}}';google.pmc=JSON.parse(pmc);})();</script>        </body></html>
------------------------------------------------------------------------
BUILD SUCCESS

