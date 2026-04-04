# テンプレートコードから4.0への移行
1. `pom.xml`の`parent>artifactId`が`spring-boot-starter-parent`の`version`を`3.0.0`から`4.0.0`に変更します。
2. `pom.xml`から`io.rest-assured:rest-assured`の依存関係を削除します。
3. `pom.xml`の`properties>java.version`を`XX`から`25`に変更します。
4. `AppConfig.java`の内容は必要なくなっているため、削除します。
5. `HelloControllerTest.java`のコードをjUnitを利用したコードに変更します。

# ポート競合の抑制
1. `src/main/resources/application.properties`に以下の内容を追加します。
    ```properties
    server.port=8080
    ```
2. `HelloControllerTest.java`の`@SpringBootTest`アノテーションに`webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT`を追加します。
3. `test/resources/application.properties`に以下の内容を追加します。
    ```properties
    server.port=8080
    ```
4. `HelloControllerTest.java`のソースを以下のように変更します。
    ```java
    @SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
    public class HelloControllerTest {
        private HelloController helloController;

        @BeforeEach
        public void setUp() {
            helloController = new HelloController();
        }

        @Test
        public void testHello() {
            String result = helloController.hello();
            assert result.equals("Hello World!");
        }
    }
    ```
