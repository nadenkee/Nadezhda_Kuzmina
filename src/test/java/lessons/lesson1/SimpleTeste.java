package lessons.lesson1;// скачать плагин .ignore, папку idea не пушить
// организовать структуру maven проекта
// File - New Project - Maven - Java SDK - next.
// Group ID - организация, которая выпустила этот артефакт ИД - epam.com
// Artefact ID - название нашего проекта - automation-winter-2019
// Projet Name & Location = положить в промежуточную папку
// Создать, новое окно
// Нам нужны SRC и pom.xml. Их копируем и вставляем в НАШ проект первоначальный. Идея спрашивает, добавить ли их в гит. ДОбавляем.
// Отправляем в репозиторий (это у нас и есть точка синхронизации) только помник. гитигнгр тоже
// Commit & Push
// закрываем проект, откуда копировали, пушо он нам больше не нужен
// скачиваем maven testNG - выбираем 6.14.3 - забираем код депенденси и вставляем в помник ДО </Project>
// тег scope определеяет, в какой из библиотек можно использовать тесты, поэтому убираем тег скоуп вообще, т.к. у нас ВЕСЬ проект для тестов
// то же самое с Selenium - maven Selenium - Selenium Java - 3.141.59
// рефрешим помник, чтоб все обновилось - справа панель Build Tools - сначала правой кнопкой на помнике, Add as Maven Progect ВНИЗУ - а потом справа в панели жмем кнопку "Обновить"
// папка src содержит папки main и test
// все те классы, которые внутри себя будут содержать тесты, должны лежать в папке тест/джава
// все то, что НЕ содержит в себе тестов - в папке мэйн/джава
// в папку тест/джава создаем новый класс, называем его SimpleTest
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTeste {


    @BeforeClass
    public void BeforeClass() {

        setProperty ("WebDriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @Test
    public void SimpleTest () {

        //1

        WebDriver driver = new ChromeDriver(); //импортим два класса, которые предлагает идея
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2
        driver.manage().window().maximize(); //развернули окно браузера максимально

        String handle = driver.getWindowHandle(); //получаем ID нулевой вкладки , если хотим Linked Hash Set со ВСЕМИ вкладками - то добавляем в конце s
        driver.switchTo().frame(handle);

        //3
        assertEquals(driver.getTitle(), "Home Page");

        //4


        // работаем с контентом, By - класс в селениуме
        driver.findElement(By.cssSelector("id='user-icon'")).click();
        driver.findElement(By.cssSelector("id='name'")).sendKeys("epam");
        driver.findElement(By.cssSelector("id='password'")).sendKeys("1234");
        driver.findElement(By.cssSelector("id='login-button'")).click();

        //5

        driver.close();
    }

}

// запускаем тест, всё падает
// ищем хром драйвер
// загружаем его с chromedriver.chromium.org , самый последний релиз
// кладем chromedriver.exe файл в самый корень проекта ко всем остальным файликам
// пушим его в гит
// запускаем. все хорошо. окно открылось, тест зеленый. окно не закрылось, и не должно было.
//

// если бы мы не положили наш экзешник в корень, то мы бы должны были setProperty ("адрес оного на диске") перед созданием драйвера в тексте теста
// предпочтительнее использовать относительные пути, а не абсолютные
// относительный берется относительно папки, где лежит наш проект, причем имя этой папки тоже стираем
//


// ЩА БУДЕМ использовать ассерты
// переключаемся между вкладками с помощью ID - driver.switchTo().frame("frame-id");
//получаем id вкладок с помощью команды setWindowHandlers

// поиграли с кнопками и тд, делаем коммит и пуш. хоткей Ctrl+K , Ctrl+Shift+K


/* 2 лекция. СЕлениум - это инструмент для автоматизации, ЭТО ПРОСТО НАБОР КЛАССОВ */


