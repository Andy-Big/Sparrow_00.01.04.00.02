[//]: # (Downloads Badge Center)
[//]: # "Centered Image"
<div align="center">

[![GitHub Downloads](https://img.shields.io/github/downloads/Andy-Big/Rigol-DHO800-900-Sparrow_mod/total?style=flat-square)](https://github.com/Andy-Big/Rigol-DHO800-900-Sparrow_mod/releases)

</div>

[English version](#english-version)

# Модифицированное приложение Sparrow (интерфейс) для осциллографа Rigol DHO800/DHO900

![logo](_images/sparrow_logo.png)

#### *Выражаю благодарность всем участникам темы на форумах EEvblog и 4PDA за помощь, подсказки и советы - [https://www.eevblog.com/forum/testgear/hacking-the-rigol-dho800900-scope](https://www.eevblog.com/forum/testgear/hacking-the-rigol-dho800900-scope) , [https://4pda.to/forum/index.php?showtopic=1080959](https://4pda.to/forum/index.php?showtopic=1080959)*

Если вам понравился этот проект, то вы можете поддержать его 300 рублями через ЮМани по [вот этой ссылке](https://yoomoney.ru/quickpay/fundraise/button?billNumber=17P19CIPI3F.250114&)

## Содержание

* [Главное](#главное)
* [Установка](#установка)
* [История изменений](#история-изменений)
* [Скриншоты](#скриншоты)


# Главное

Модификация приложения Rigol DHO800/DHO900 повышает удобство использования осциллографа, улучшая интерфейс и добавляя в него новые возможности.

## Текущие изменения по сравнению с оригинальной версией

- Значения вертикальной шкалы теперь не перепрыгивают на левую или правую сторону главного окна осциллограммы при раскрытии и сворачивании панели измерений, а всегда остаются слева.
- Панель измерений полностью прозрачная, список измерений в ней прижат вниз, так что при 3-4 измерениях они практически не мешают просмотру сигнала.
- Изменена заставка при запуске приложения (сплэшскрин). Это сделано для того чтобы было видно когда заканчивается загрузки системы и запускается само приложение.
- Двойным тапом на иконку канала внизу экрана у этого канала изменяется режим блокировки между AC и DC.
- В иконки каналов внизу экрана добавлено отображение текущего делителя щупа. [Смотреть скриншоты](#скриншоты).
- Пункты результатов измерений на панели слева уменьшены по высоте для того чтобы можно было видеть большее количество измерений одновременно. Кроме того, немного увеличен шрифт значений измерений для более легкой читаемости. [Смотреть скриншоты](#скриншоты)
- Раскрытые пункты результатов измерений изменены на табличный вид: имя параметра и слева от него значение этого параметра. Это уменьшило высоту раскрытого пункта, позволив видеть одновременно до трех раскрытых пунктов. У значений так же немного увеличен шрифт для более легкой читаемости. [Смотреть скриншоты](#скриншоты).
- У стрелок раскрытия и закрытия пунктов результатов измерений увеличена область чувствительности к нажатию. Теперь раскрыть и закрыть пункт гораздо проще.
- В левый верхний угол окна осциллограммы добавлена иконка раскрытия этого окна на весь экран. Этой же иконкой окно сворачивается обратно в оригинальный размер. [Смотреть скриншоты](#скриншоты).
- В правом нижнем углу включено отображение текущего времени и даты.


# Установка

Модифицированное приложение существует в двух версиях:  
- **Sparrow_axxx.apk** - версия для установки на пропатченную систему - это рекомендованный вариант.
- **Sparrow_axxx_u.apk** - версия для установки на оригинальную систему.

## Что такое патч системы Android и зачем он нужен?

Система Android обладает системой разграничения прав пользователей и системой проверки подписи приложений. Самыми широкими правами обладает пользователь **system** и если приложение хочет установиться как системное и получать доступ к некоторым ограниченным системным функциям, то оно должно заявить себя как приложение с правами пользователя **system**. Но проблема в том, что для того, чтобы приложение могло заявить себя как системное, оно должно быть подписано тем же ключом, которым подписана сама сборка Android. Такой ключ имеется только у производителя устройства, а значит никто больше не может подписать приложение с правами пользователя **system**.  

Патч системы Android заключается в том чтобы отключить проверку подписи приложений. Это делается путем замены одного из системных файлов, который отвечает за проверку подписи приложений. После этого любое приложение может заявиться как системное приложение с правами пользователя **system** и получить доступ к ограниченным функциям Андроида, будучи подписанным любым ключом.  

Патч системы устанавливается только один раз, в дальнейшем при переустановке или обновлении модифицированного приложения его повторная установка уже не требуется. Этот патч так же не мешает работе оригинального приложения, так что если вы решите откатиться к оригинальной версии, то вам не придется откатывать патч. Хотя если по каким-то причинам захочется откатить патч, то это легко сделать.

### Какая разница между версиями?

- Версия **Sparrow_axxx.apk** - это версия для установки на пропатченную систему. Она заявляет себя как системное приложение с правами пользователя **system** и может получать доступ к любым системным функциям.
- Версия **Sparrow_axxx_u.apk** - это версия для установки на оригинальную систему. Она не заявляется как системное приложение и работает с ограниченными правами обычного пользователя. В результате эта версия не сможет, например, сохранять скриншоты, т.к. Андроид не даст ей доступ к содержимому экрана.

## Подготовка к установке

Для установки как патча, так и любой из версий модифицированного приложения, вам потребуется ADB. Загрузить его можно с [официального сайта](https://developer.android.com/studio/releases/platform-tools).  

Осциллограф должен быть подключен к одной сети с компьютером - кабелем или через Wi-Fi.  

Необходимо скачать архив нужной версии из [раздела релизов](/releases). Распакуйте эти файлы в каталог с ADB (или в любой другой если вы добавили ADB в системные переменные среды). Запустите в этой папке командную строку (открыть эту папку в проводнике и в его адресной строке ввести команду cmd) и дальше вводите в командной строке показанные ниже команды. Вводить нужно только то, что выделено ***жирным курсивом***, можно прямо копировать указанные команды и вставлять их в командную строку.

## Установка патча системы

Первой идет команда подключения ADB к устройству по его IP-адресу. IP-адрес осциллографа можно увидеть в самом осциллографе в меню **Utility->IO**. Подставьте адрес своего осциллографа вместо 192.168.1.41:  
***adb connect 192.168.1.41:55555***  
В ответ ADB должен сообщить об успешном подключении:  
*connected to 192.168.1.41:55555*

Теперь нужно загрузить в осциллограф пропатченный системный файл:  
***adb push services.jar /rigol/data/***  
И получить ответ об успешности:  
*services.jar: 1 file pushed, 0 skipped. 59.7 MB/s (3179392 bytes in 0.051s)*  

Теперь запустите шелл ADB.  
***adb shell***  
При этом вместо подсказки командной строки системы (например D:\\Rigol>) появится подсказка командной строки осциллографа, и далее команды вводятся в этой командной строке:  
*rk3399_rigol:/ \$*  

Получите права администратора:  
***su***  
Символ $ в подсказке сменится на символ #:  
*rk3399_rigol:/ #*   

Сделайте системный раздел доступным для записи:  
***mount -o rw,remount  /system***  

Удалите оригинальный системный файл:  
***rm  /system/framework/services.jar -f***  

Удалите также его остаток в другом каталоге:  
***rm  /system/framework/oat/arm64/services.odex -f***  

И его кэш в другом каталоге тоже удалите:  
***rm  /data/dalvik-cache/arm64/system@framework@services.jar@classes.dex***  

Перенесите загруженный ранее в осциллограф пропатченный системный файл в системный раздел:  
***mv  /rigol/data/services.jar  /system/framework***  

Верните обратно системному разделу режим только для чтения:  
***mount -o ro,remount  /system***  

Команда синхронизации чтобы все изменения файловой системы точно сохранились:  
***sync***  

Перезагрузите осциллограф:
***reboot***  

В процессе перезагрузки шелл ADB отвалится и вернется подсказка командной строки вашей системы. Все, теперь ваш осциллограф верит всем приложения на слово, что они являются системными, не проверяя верность ключа, которым они подписаны :)  
Если после перезагрузки осциллограф зависнет на экране загрузки - ничего страшного, просто выключите осциллограф длительным нажатием кнопки питания (или выдернув коннектор питания) и включите снова.

## Установка модифицированного приложения

Внимание! Установка версии **Sparrow_axxx.apk** возможна только на пропатченной ранее системе. На оригинальной системе устанавливается версия **Sparrow_axxx_u.apk**.

Первой идет команда подключения ADB к устройству по его IP-адресу. IP-адрес осциллографа можно увидеть в самом осциллографе в меню **Utility->IO**. Подставьте адрес своего осциллографа вместо 192.168.1.41:  
***adb connect 192.168.1.41:55555***  
В ответ ADB должен сообщить об успешном подключении:  
*connected to 192.168.1.41:55555*
Или о том, что он уже подключен:  
*already connected to 192.168.1.41:55555*  

Удалите установленное приложение осциллографа:  
***adb uninstall com.rigol.scope***  
Приложение на осциллографе должно закрыться и должен быть выдан ответ об успешности:  
*Success*  

Установите модифицированное приложение:  
***adb install -g -r Sparrow_axxx.apk***  
(или ***adb install -g -r Sparrow_axxx_u.apk*** если вы устанавливаете на непропатченную систему)  
Это может занять довольно много времени, но в итоге должен быть выдан ответ об успешности:  
*Performing Streamed Install*  
*Success*  

Приложение осциллографа должно само запуститься в течении 5-20 сек, но если не запускается - просто выключите осциллограф длительным нажатием кнопки питания (или выдернув коннектор питания) и включите снова.



# История изменений

#### **a004** 24.01.2025

- Значения вертикальной шкалы теперь не перепрыгивают на левую или правую сторону главного окна осциллограммы при раскрытии и сворачивании панели измерений, а всегда остаются слева.
- Панель измерений полностью прозрачная, список измерений в ней прижат вниз, так что при 3-4 измерениях они практически не мешают просмотру сигнала.

#### **a003** 19.01.2025

- Изменена заставка при запуске приложения (сплэшскрин). Это сделано для того чтобы было видно когда заканчивается загрузка системы и запускается само приложение.
- Двойным тапом на иконку канала внизу экрана у этого канала изменяется режим блокировки между AC и DC.

#### **a002** 13.01.2025

- В иконки каналов внизу экрана добавлено отображение текущего делителя щупа. [Смотреть скриншоты](#скриншоты).
- Пункты результатов измерений на панели слева уменьшены по высоте для того чтобы можно было видеть большее количество измерений одновременно. Кроме того, немного увеличен шрифт значений измерений для более легкой читаемости. [Смотреть скриншоты](#скриншоты)
- Раскрытые пункты результатов измерений изменены на табличный вид: имя параметра и слева от него значение этого параметра. Это уменьшило высоту раскрытого пункта, позволив видеть одновременно до трех раскрытых пунктов. У значений так же немного увеличен шрифт для более легкой читаемости. [Смотреть скриншоты](#скриншоты).
- У стрелок раскрытия и закрытия пунктов результатов измерений увеличена область чувствительности к нажатию. Теперь раскрыть и закрыть пункт гораздо проще.
- В левый верхний угол окна осциллограммы добавлена иконка раскрытия этого окна на весь экран. Этой же иконкой окно сворачивается обратно в оригинальный размер. [Смотреть скриншоты](#скриншоты).
- В правом нижнем углу включено отображение текущего времени и даты.

# Скриншоты

### Три окна в обычном режиме

![logo](_images/RigolDS0.png)

### Три окна в режиме "на весь экран"

![logo](_images/RigolDS1.png)

### Два окна горизонтально в обычном режиме

![logo](_images/RigolDS9.png)

### Два окна горизонтально в режиме "на весь экран"

![logo](_images/RigolDS10.png)

### Два окна вертикально в обычном режиме

![logo](_images/RigolDS6.png)

### Два окна вертикально в режиме "на весь экран"

![logo](_images/RigolDS7.png)

### Одно окно в режиме "на весь экран"

![logo](_images/RigolDS5.png)
![logo](_images/RigolDS12.png)
![logo](_images/RigolDS17.png)


### Панель результатов измерений в обычном режиме

![logo](_images/RigolDS43.png)
![logo](_images/RigolDS44.png)
![logo](_images/RigolDS45.png)

### Панель результатов измерений в режиме "на весь экран"

![logo](_images/RigolDS46.png)
![logo](_images/RigolDS47.png)
![logo](_images/RigolDS48.png)

---
<br>
<br>
<br>

### English version

# Modified Sparrow Application (interface) for Rigol DHO800/DHO900 Oscilloscope

![logo](_images/sparrow_logo.png)

#### *I would like to thank all participants of the EEvblog and 4PDA forum threads for their help, hints and advice - [https://www.eevblog.com/forum/testgear/hacking-the-rigol-dho800900-scope](https://www.eevblog.com/forum/testgear/hacking-the-rigol-dho800900-scope), [https://4pda.to/forum/index.php?showtopic=1080959](https://4pda.to/forum/index.php?showtopic=1080959)*

## Contents

* [Main](#main)
* [Installation](#installation)
* [Change History](#change-history)
* [Screenshots](#screenshots)

# Main

The modification of the Rigol DHO800/DHO900 application improves the usability of the oscilloscope by enhancing the interface and adding new features.

## Current Changes Compared to Original Version

- The vertical scale values ​​no longer jump to the left or right side of the main oscillogram window when expanding and collapsing the measurement panel, but always remain on the left.
- The measurement panel is completely transparent, the list of measurements in it is pressed down, so that with 3-4 measurements they practically do not interfere with viewing the signal.
- Changed the application splash screen at startup. This is done to show when the system finishes loading and the application itself starts.
- Double-tapping the channel icon at the bottom of the screen toggles that channel's coupling mode between AC and DC.
- Added probe attenuation factor display to channel icons at the bottom of the screen. [See screenshots](#screenshots).
- Measurement result items on the left panel have been reduced in height to show more measurements simultaneously. Additionally, the measurement value font size has been slightly increased for better readability. [See screenshots](#screenshots)
- Expanded measurement result items changed to tabular view: parameter name with its value to the left. This reduced the expanded item height, allowing up to three expanded items to be visible simultaneously. Values also have slightly increased font size for better readability. [See screenshots](#screenshots).
- Increased touch sensitivity area for measurement result item expand/collapse arrows. Now it's much easier to expand and collapse items.
- Added a full-screen icon to the top left corner of the waveform window. The same icon collapses the window back to original size. [See screenshots](#screenshots).
- Enabled current time and date display in the bottom right corner.

# Installation

The modified application exists in two versions:
- **Sparrow_axxx.apk** - version for installation on patched system - this is the recommended option.
- **Sparrow_axxx_u.apk** - version for installation on original system.

## What is Android System Patch and Why is it Needed?

Android system has user permission segregation and application signature verification systems. The **system** user has the broadest rights, and if an application wants to install as system and access certain restricted system functions, it must declare itself as an application with **system** user rights. However, the problem is that for an application to declare itself as system, it must be signed with the same key that signed the Android build itself. Only the device manufacturer has such a key, meaning no one else can sign an application with **system** user rights.

The Android system patch involves disabling application signature verification. This is done by replacing one of the system files responsible for verifying application signatures. After this, any application can declare itself as a system application with **system** user rights and access restricted Android functions while being signed with any key.

The system patch is installed only once; subsequent reinstallation or updates of the modified application do not require its reinstallation. This patch also doesn't interfere with the original application's operation, so if you decide to roll back to the original version, you won't need to roll back the patch. Although if for some reason you want to roll back the patch, it's easy to do.

### What's the Difference Between Versions?

- Version **Sparrow_axxx.apk** - this is the version for installation on patched system. It declares itself as a system application with **system** user rights and can access any system functions.
- Version **Sparrow_axxx_u.apk** - this is the version for installation on original system. It doesn't declare itself as a system application and works with limited regular user rights. As a result, this version won't be able to, for example, save screenshots, as Android won't give it access to screen content.

## Installation Preparation

For installing both the patch and any version of the modified application, you'll need ADB. You can download it from the [official website](https://developer.android.com/studio/releases/platform-tools).

The oscilloscope must be connected to the same network as the computer - via cable or Wi-Fi.

You need to download the archive of the needed version from the [releases section](/releases). Extract these files to the ADB directory (or any other if you've added ADB to system environment variables). Launch command prompt in this folder (open this folder in explorer and enter cmd in its address bar) and then enter the commands shown below in the command prompt. Enter only what's highlighted in ***bold italic***, you can directly copy the specified commands and paste them into the command prompt.

## System Patch Installation

First is the ADB connection command to the device by its IP address. The oscilloscope's IP address can be seen in the oscilloscope itself in the **Utility->IO** menu. Replace 192.168.1.41 with your oscilloscope's address:  
***adb connect 192.168.1.41:55555***  
ADB should respond with successful connection:  
*connected to 192.168.1.41:55555*  

Now you need to upload the patched system file to the oscilloscope:  
***adb push services.jar /rigol/data/***  
And get a success response:  
*services.jar: 1 file pushed, 0 skipped. 59.7 MB/s (3179392 bytes in 0.051s)*  

Now launch ADB shell.  
***adb shell***  
The system command prompt (e.g., D:\\Rigol>) will be replaced with the oscilloscope's command prompt, and further commands are entered in this command prompt:  
*rk3399_rigol:/ \$*  

Get administrator rights:  
***su***  
The $ symbol in the prompt will change to #:  
*rk3399_rigol:/ #*  

Make the system partition writable:  
***mount -o rw,remount /system***  

Delete the original system file:  
***rm /system/framework/services.jar -f***  

Also delete its remnant in another directory:  
***rm /system/framework/oat/arm64/services.odex -f***  

And delete its cache in another directory too:  
***rm /data/dalvik-cache/arm64/system@framework@services.jar@classes.dex***  

Move the previously uploaded patched system file to the system partition:  
***mv /rigol/data/services.jar /system/framework***  

Return the system partition back to read-only mode:  
***mount -o ro,remount /system***  

Sync command to ensure all filesystem changes are saved:  
***sync***  

Reboot the oscilloscope:  
***reboot***  

During reboot, the ADB shell will disconnect and return to your system's command prompt. Now your oscilloscope trusts all applications' claims about being system applications without verifying the key they're signed with :)
If after reboot the oscilloscope hangs on the loading screen - no worries, just turn off the oscilloscope by long-pressing the power button (or unplugging the power connector) and turn it on again.

## Modified Application Installation

Attention! Installation of **Sparrow_axxx.apk** version is only possible on a previously patched system. On original system, install the **Sparrow_axxx_u.apk** version.

First is the ADB connection command to the device by its IP address. The oscilloscope's IP address can be seen in the oscilloscope itself in the **Utility->IO** menu. Replace 192.168.1.41 with your oscilloscope's address:  
***adb connect 192.168.1.41:55555***  
ADB should respond with successful connection:  
*connected to 192.168.1.41:55555*  
Or that it's already connected:  
*already connected to 192.168.1.41:55555*  

Delete the installed oscilloscope application:  
***adb uninstall com.rigol.scope***
The application on the oscilloscope should close and a success response should be given:  
*Success*  

Install the modified application:  
***adb install -g -r Sparrow_axxx.apk***  
(or ***adb install -g -r Sparrow_axxx_u.apk*** if you're installing on unpatched system)  
This might take quite some time, but eventually should give a success response:  
*Performing Streamed Install*  
*Success*  

The oscilloscope application should start itself within 5-20 seconds, but if it doesn't start - just turn off the oscilloscope by long-pressing the power button (or unplugging the power connector) and turn it on again.

# Change History

#### **a004** 24.01.2025

- The vertical scale values ​​no longer jump to the left or right side of the main oscillogram window when expanding and collapsing the measurement panel, but always remain on the left.
- The measurement panel is completely transparent, the list of measurements in it is pressed down, so that with 3-4 measurements they practically do not interfere with viewing the signal.

#### **a003** 19.01.2025

- Changed the application splash screen at startup. This is done to show when the system finishes loading and the application itself starts.
- Double-tapping the channel icon at the bottom of the screen toggles that channel's coupling mode between AC and DC.

#### **a002** 13.01.2025

- Added probe attenuation factor display to channel icons at the bottom of the screen. [See screenshots](#screenshots).
- Measurement result items on the left panel have been reduced in height to show more measurements simultaneously. Additionally, the measurement value font size has been slightly increased for better readability. [See screenshots](#screenshots)
- Expanded measurement result items changed to tabular view: parameter name with its value to the left. This reduced the expanded item height, allowing up to three expanded items to be visible simultaneously. Values also have slightly increased font size for better readability. [See screenshots](#screenshots).
- Increased touch sensitivity area for measurement result item expand/collapse arrows. Now it's much easier to expand and collapse items.
- Added a full-screen icon to the top left corner of the waveform window. The same icon collapses the window back to original size. [See screenshots](#screenshots).
- Enabled current time and date display in the bottom right corner.

# Screenshots

### Three windows in normal mode

![logo](_images/RigolDS0.png)

### Three windows in full-screen mode

![logo](_images/RigolDS1.png)

### Two windows horizontally in normal mode

![logo](_images/RigolDS9.png)

### Two windows horizontally in full-screen mode

![logo](_images/RigolDS10.png)

### Two windows vertically in normal mode

![logo](_images/RigolDS6.png)

### Two windows vertically in full-screen mode

![logo](_images/RigolDS7.png)

### One window in full-screen mode

![logo](_images/RigolDS5.png)
![logo](_images/RigolDS12.png)
![logo](_images/RigolDS17.png)

### Measurement results panel in normal mode

![logo](_images/RigolDS43.png)
![logo](_images/RigolDS44.png)
![logo](_images/RigolDS45.png)

### Measurement results panel in full-screen mode

![logo](_images/RigolDS46.png)
![logo](_images/RigolDS47.png)
![logo](_images/RigolDS48.png)
