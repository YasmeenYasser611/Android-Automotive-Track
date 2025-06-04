# Android Auto  Day1:
### set up phone environment:

1. settings -> App Managment ->App list -> Android Auto app 
2. Additional settings in the app.
3. Scroll down to version, click it several times until you unlock Developers' settings.
4. Click on the 3 dots at the top right corner and choose Developer Settings.
5. Click on Android Mode, choose Developer.
6. Enable Unknown Resources.
7. Go back, Then click on the 3 dots at the top right corner and Start Head Unit Server.

### set up environment:

```bash

sudo apt-get install libc++1 libc++abi1

alias dhu='adb forward tcp:5277 tcp:5277 && ~/Android/Sdk/extras/google/auto/desktop-head-unit'

```

then but it in bashrc:

```bash
vim ~/.bashrc 

alias dhu='adb forward tcp:5277 tcp:5277 && /home/yasmeen/Android/Sdk/extras/google/auto/desktop-head-unit'

```

then connect the phone and :
```bash
dhu

```

then the android auto screen will appers 




