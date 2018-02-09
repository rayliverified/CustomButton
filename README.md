[![GitHub release](https://img.shields.io/github/release/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton/releases) [![GitHub Release Date](https://img.shields.io/github/release-date/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![Libraries.io for GitHub](https://img.shields.io/librariesio/github/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![GitHub issues](https://img.shields.io/github/issues/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/badges/shields.svg)](https://github.com/searchy2/CustomButton) [![GitHub top language](https://img.shields.io/github/languages/top/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton)
# Custom Button

![Screenshots](screenshots/Custom-Button-Cover_1280x.gif)

Custom Button provides a beautiful and minimalistic outline button with many appearance customization options.

This library is part of the Custom UI collection of beautiful, minimalistic, and customizable Android UI components.

![Screenshots](screenshots/Custom-Button-Screenshot_1280x.jpg)

# Gradle Dependency

Add this line to your `build.gradle` project. Use the latest release version for the version code. 

```java
repositories {
    maven { url 'https://jitpack.io' }
}
implementation 'com.github.searchy2:CustomButton:latest-version'
```
# Usage

Just drag and drop the following XML into your layout. That's it! 

```java
<stream.custombutton.CustomButton
    android:id="@+id/btn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Custom Button"
    android:textSize="18sp"
    android:singleLine="true"
    android:ellipsize="none"
    app:btn_cornerRadius="20dp"
    app:btn_strokeWidth="1dp"
    app:btn_strokeColor="#008af9"
    app:btn_buttonColor="#00FFFFFF"
    app:btn_buttonSelectColor="#008af9"
    app:btn_textColor="#008af9"
    app:btn_textSelectColor="#FFFFFF"/>
``` 

# Customization

Custom Button can be customized via XML and programmatically. Custom Button extends AppCompatTextView so all TextView functionality is available in addition to the methods listed below. 

### XML Attributes

`btn_buttonColor` - background color. 

`btn_buttonSelectColor` - background color when pressed. 

`btn_strokeColor` - outline color.

`btn_strokeSelectColor` - outline color when pressed. 

`btn_textColor` - text color.

`btn_textSelectColor` - text color when pressed. 

`btn_strokeWidth` - outline thickness (in px).

`btn_cornerRadius` - rounded corners (in px).

### Programmatically

`setPressStatus(boolean isPress)` - set button appearance to selected/unselected state.

`setDrawableLeft(int imgResId)` - set button left drawable.

`setDrawableLeft(int imgResId, int width, int height)`

```java
imgResId - drawable ID.
width - drawable width in px.
height - drawable height in px. 
```

`setDrawableRight(int imgResId)` - set button right drawable.

`setDrawableRight(int imgResId, int width, int height)` - set button right drawable with custom width and height parameters.

`setColor(int textnormal, int textselected, int buttonnormal, int buttonselected, int strokenormal, int strokeselected)`

```java
textnormal - text color.
textselected - text color when pressed.
buttonnormal - background color.
buttonselected - background color when pressed.
strokenormal - outline color.
strokeselected - outline color when pressed. 
```
`colorBurn(int RGBValues)` - The value of RGB is made up of alpha (transparency), red (red), green (green), blue (blue). In Android, RGB is usually represented as a hexadecimal. For example: "#FFAABBCC", from the left to the right, every two letters represent alpha (transparency), red, green, blue. Each color has a value of 0 to 255. Using the following shift method, we can get the darkened version of each color. 

View the sample app for additional customization options.