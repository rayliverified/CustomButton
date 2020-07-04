![Screenshots](screenshots/Custom-Button-Cover_1280x.gif)

# Custom Button

[![GitHub release](https://img.shields.io/github/release/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton/releases) [![GitHub Release Date](https://img.shields.io/github/release-date/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![Libraries.io for GitHub](https://img.shields.io/librariesio/github/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![GitHub issues](https://img.shields.io/github/issues/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![API](https://img.shields.io/badge/API-15%2B-blue.svg?style=flat-square)](https://github.com/searchy2/CustomButton) [![GitHub top language](https://img.shields.io/github/languages/top/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton)

<img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png" width="128">

> ### A beautiful and minimalistic button with outline and drawable support.

This library is part of the [Custom UI](http://rayliverified.com/index.php/code/) collection of beautiful, minimalistic, and customizable Android UI components.

![Screenshots](screenshots/Custom-Button-Screenshot_1280x.jpg)

# Usage

[![GitHub release](https://img.shields.io/github/release/searchy2/CustomButton.svg?style=flat-square)](https://github.com/searchy2/CustomButton/releases)

Add this library to `build.gradle`.

```java
repositories {
    maven { url 'https://jitpack.io' }
}
implementation 'com.github.searchy2:CustomButton:latest-version'
```

Use Custom Button in your layout with the following XML.

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

## About

CustomButton was created as a replacement for Android's Material buttons. CustomButtons are flat, have better drawable support, and look consistent across Android versions. Here at Codelessly, we're building a Flutter website/app builder, development tools, and UI templates to increase productivity. If that sounds interesting, you'll want to subscribe to updates below 😎

CustomButton is licensed under Zero-Clause BSD and released as Emailware. If you like this project or it helped you, please subscribe to updates. Although it is not required, you might miss the goodies we share!

<a href="https://codelessly.com/?utm_medium=banner&utm_campaign=newsletter_subscribe" target="_blank"><img src="https://raw.githubusercontent.com/Codelessly/ResponsiveFramework/master/packages/Email%20Newsletter%20Signup.png"></a>

# Examples

![Screenshots](screenshots/button_default.png)

```java
<stream.custombutton.CustomButton
    android:id="@+id/btn1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:paddingTop="6dp"
    android:paddingBottom="6dp"
    android:paddingLeft="12dp"
    android:paddingRight="12dp"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:layout_gravity="center_horizontal"
    android:gravity="center"
    android:text="Default"
    android:textSize="18sp"
    android:singleLine="true"
    android:ellipsize="none"/>
```

![Screenshots](screenshots/button_elegant.png)

```java
<stream.custombutton.CustomButton
    android:id="@+id/btn2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:paddingTop="6dp"
    android:paddingBottom="6dp"
    android:paddingLeft="12dp"
    android:paddingRight="12dp"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:layout_gravity="center_horizontal"
    android:gravity="center"
    android:text="Elegant"
    android:textSize="18sp"
    android:singleLine="true"
    android:ellipsize="none"
    app:btn_cornerRadius="20dp"
    app:btn_strokeWidth="1dp"
    app:btn_strokeColor="@color/white"
    app:btn_strokeSelectColor="@color/white_pressed"
    app:btn_buttonColor="@color/transparent"
    app:btn_textColor="@color/white"
    app:btn_textSelectColor="@color/white_pressed"/>

```

![Screenshots](screenshots/button_normal.png)

```java
<stream.custombutton.CustomButton
    android:id="@+id/btn3"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:paddingTop="6dp"
    android:paddingBottom="6dp"
    android:paddingLeft="12dp"
    android:paddingRight="12dp"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:layout_gravity="center_horizontal"
    android:gravity="center"
    android:text="Normal"
    android:textSize="18sp"
    android:singleLine="true"
    android:ellipsize="none"
    app:btn_cornerRadius="20dp"
    app:btn_strokeWidth="1dp"
    app:btn_strokeColor="#008af9"
    app:btn_buttonColor="@color/transparent"
    app:btn_buttonSelectColor="#008af9"
    app:btn_textColor="#008af9"
    app:btn_textSelectColor="@color/white"/>

```

![Screenshots](screenshots/button_confirm.png)

```java
<stream.custombutton.CustomButton
    android:id="@+id/btn4"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:paddingTop="2dp"
    android:paddingBottom="6dp"
    android:paddingLeft="12dp"
    android:paddingRight="12dp"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:layout_gravity="center_horizontal"
    android:gravity="center"
    android:text="Confirm"
    android:textSize="18sp"
    android:singleLine="true"
    android:ellipsize="none"
    app:btn_cornerRadius="20dp"
    app:btn_strokeWidth="1dp"
    app:btn_buttonColor="@color/green"
    app:btn_buttonSelectColor="@color/green_light"
    app:btn_strokeColor="@color/green"
    app:btn_strokeSelectColor="@color/green_light"
    app:btn_textColor="@color/white"/>

```

![Screenshots](screenshots/button_cancel.png)

```java
<stream.custombutton.CustomButton
    android:id="@+id/btn5"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:paddingTop="2dp"
    android:paddingBottom="6dp"
    android:paddingLeft="12dp"
    android:paddingRight="12dp"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:layout_gravity="center_horizontal"
    android:gravity="center"
    android:text="Cancel"
    android:textSize="18sp"
    android:singleLine="true"
    android:ellipsize="none"
    app:btn_cornerRadius="20dp"
    app:btn_strokeWidth="1dp"
    app:btn_buttonColor="@color/red"
    app:btn_buttonSelectColor="@color/red_light"
    app:btn_strokeColor="@color/red"
    app:btn_strokeSelectColor="@color/red_light"
    app:btn_textColor="@color/white"/>

```
# Customization

Custom Button can be customized via XML and programmatically. Custom Button extends AppCompatTextView so all TextView functionality is available in addition to the methods listed below. 

### XML Attributes

|Attribute|Description| 
|--|--|
|btn_buttonColor|default background color|
|btn_buttonSelectColor|selected background color|
|btn_strokeColor|default outline color|
|btn_strokeSelectColor|selected outline color|
|btn_textColor|default text color|
|btn_textSelectColor|selected text color|
|btn_strokeWidth|outline thickness (px)|
|btn_cornerRadius|rounded corners radius (px)|

### Programmatically

|Method|Description| 
|--|--|
|setPressStatus(boolean isPress)|set button appearance to selected/default state|
|setDrawableLeft(int imgResId)|set button left drawable|
|setDrawableLeft(int imgResId, int width, int height)|set button left drawable with custom width and height parameters </br> `imgResId - drawable ID` </br> `width - drawable width in px` </br> `height - drawable height in px`|
|setDrawableRight(int imgResId)|set button right drawable|
|setDrawableRight(int imgResId, int width, int height)|set button right drawable with custom width and height parameters </br> `imgResId - drawable ID` </br> `width - drawable width in px` </br> `height - drawable height in px`|
|setColor(int textnormal, int textselected, int buttonnormal, int buttonselected, int strokenormal, int strokeselected)|`textnormal - text color` </br> `textselected - text color when pressed` </br> `buttonnormal - background color` </br> `buttonselected - background color when pressed` </br> `strokenormal - outline color` </br> `strokeselected - outline color when pressed` |
|colorBurn(int RGBValues)|Get the darkened version of each color. The value of RGB is made up of alpha (transparency), red (red), green (green), blue (blue). In Android, RGB is usually represented as a hexadecimal. For example: "#FFAABBCC", from the left to the right, every two letters represent alpha (transparency), red, green, blue. Each color has a value of 0 to 255. This method shifts the color values and darkens the color. |

View the sample app for additional customization options.

# Features Wishlist

These features would make this library even more awesome. Please contribute to this library by developing any of the features below.

---

>Elevation Shadows

Currently, Custom Button does not support elevation or shadows. A current design trend is large drop shadows on buttons. The drop shadows are also colored which creates a really nice glowing look. It would be great if Custom Button supported glowing drop shadows or any drop shadows at all. 

>Gradient Background

Gradient backgrounds are very trendy and all designers are using them in UI mockups. Unfortunately, gradients are very difficult to do well on Android. Custom Button provides a good starting point to create buttons with gradient backgrounds. 

---

Pull requests are most welcome!

If you've fixed a bug or have a feature you've added, just create a pull request. If you've found a bug, file an issue. If you have any questions or would like to discuss upcoming features, please get in touch. You can get in touch with me in the Contact section below. 

# ★ Acknowledgements ★
**♥ Developer ♥**

[Ray Li](https://rayliverified.com)

**♥ Designer ♥**

[Ray Li](https://rayliverified.com)

**♥ Sponsor ♥**

[Codelessly - Flutter Website and App Builder](https://codelessly.com/?utm_medium=link&utm_campaign=direct)

# ★ Get in Touch ★
<a href="mailto:ray@codelessly.com">
  <img alt="Ray Li Email"
       src="https://lh3.googleusercontent.com/yN_m90WN_HSCohXdgC2k91uSTk9dnYfoxTYwG_mv_l5_05dV2CzkQ1B6rEqH4uqdgjA=w96" />
</a>
<a href="https://rayliverified.com">
  <img alt="Ray Li Website"
       src="https://lh3.googleusercontent.com/YmMGcgeO7Km9-J9vFRByov5sb7OUKetnKs8pTi0JZMDj3GVJ61GMTcTlHB7u9uHDHag=w96" />
</a>
<a href="https://twitter.com/RayLiVerified">
  <img alt="Ray Li Twitter"
       src="https://lh3.ggpht.com/lSLM0xhCA1RZOwaQcjhlwmsvaIQYaP3c5qbDKCgLALhydrgExnaSKZdGa8S3YtRuVA=w96" />
</a>
<a href="https://linkedin.com/in/rayliverified/">
  <img alt="Ray Li LinkedIn"
       src="https://lh3.googleusercontent.com/00APBMVQh3yraN704gKCeM63KzeQ-zHUi5wK6E9TjRQ26McyqYBt-zy__4i8GXDAfeys=w90" />
</a>
<a href="https://www.uplabs.com/ray">
  <img alt="Ray Li UpLabs"
       src="https://lh3.googleusercontent.com/fDJB4jtIgZQF_Dj7AFAPEv2dJOJE8LaLSbaiOOFejQJl3oFbkOLLScstkp699oMDcEU=w90" />
</a>
<a href="https://github.com/searchy2">
  <img alt="Ray Li GitHub"
       src="https://lh3.googleusercontent.com/L15QqmKK7Vl-Ag1ZxaBqNQlXVEw58JT2BDb-ef5t2eboDh0pPSLjDgi3-aQ3Opdhhyk=w96" />
</a>

# Apps Using This Library

Include your app here by making a `pull request`. 

<table>
    <tr>
		<td><img src="https://lh3.googleusercontent.com/tYGJBG8mc7lwC0ZxQUxif2FVMFI8L8xRkPON0ytkWVPTI67ggkrgDl3JpRu9jW0W3sLJ=w64"/></td>
		<td><a href="https://github.com/searchy2/Rocket-Notes">Rocket Notes</a></td>
	</tr>
	<tr>
		<td><img src="https://lh3.googleusercontent.com/R-vJInTblK1KBOqZaSDm_ac270QBHsiIcU9agHnN-rrp9K_lkN8rLzGIH8asCfkb420Q=w64"/></td>
		<td><a href="https://play.google.com/store/apps/details?id=io.ideastarter">Crowdfunding Community</a></td>
	</tr>
    <tr>
		<td><img src="https://lh3.googleusercontent.com/CT1M2pKlUhGx4w5UHqarn6oSU_sa7L7XRW2-hQrfNi9oou6W81PbJnWi-9PbEfC_3g=w64"/></td>
		<td><a href="https://play.google.com/store/apps/details?id=com.blankicon">Blank Icon</a></td>
	</tr>
</table>

#### Search Terms
android button, outline button, button with outline, simple, elegant, iOS button, style, UI, beautiful, customizable button
