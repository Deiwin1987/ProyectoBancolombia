import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

public class Navegador {
    public static WebDriver driver;
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.out.println("Inicializando Prueba");
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://www.google.com.co/");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).sendKeys("Bancolombia\n");

        driver.findElement(By.xpath("//cite[@class= 'iUh30 bc']")).click();

        driver.findElement(By.id("btn-transaccional")).click();

        //swichando a 2 pestaña
        String Tabs = driver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab

        //Ingresando usuario
        driver.findElement(By.id("username")).sendKeys("Manu");
        driver.findElement(By.id("btnGo")).click();

        //Seleccionando datos tablas
       WebElement table_element = driver.findElement(By.id("_KEYBRD"));
       List<WebElement> elementos = table_element.findElements(By.tagName("td"));
       // ArrayList<WebElement> elementos = new ArrayList<WebElement>(table_element.findElements(By.tagName("tr/td")));
        elementos.get(3).click();
        elementos.get(1).click();
        elementos.get(0).click();
        elementos.get(5).click();
        driver.findElement(By.id("btnGo")).click();

        //validando realizando del reto
        WebElement llamar;
        llamar = driver.findElement(By.xpath("//div[@class= 'errorTitulo']"));
        System.out.println(llamar.getText());
        if (llamar.getText().equalsIgnoreCase("Error")){
            System.out.println("Prueba realizada");
        } else {
            System.out.println("Prueba no realizada");
        }
        Thread.sleep(5000);
        //cerrando pestañas
        driver.close();
        //cambiando de pocision indice y cambiando url
        driver.switchTo().window(tabs.get(0));
        driver.get("https://youtube.com");
        driver.findElement(By.id("search")).sendKeys("Accenture Medellin\n");


        ((JavascriptExecutor) driver).executeScript("scroll(0,1300)");
        driver.close();
    }

}
