TAK REMOTE - Android starter prototype (v0.1)

इस ZIP में क्या है:
- Android Studio project starter
- Controller Mode और Receiver Mode की शुरुआती स्क्रीन
- Receiver Mode में Android का आधिकारिक screen-capture permission prompt

महत्वपूर्ण सीमाएँ:
यह अभी पूरा remote-control ऐप नहीं है। यह इंटरनेट पर वीडियो/स्क्रीन नहीं भेजता,
दूसरे फोन पर touch inject नहीं करता और QR pairing/signalling server शामिल नहीं है।
इसे पूरा बनाने के लिए सुरक्षित signalling backend, WebRTC (और जरूरत पर TURN relay),
authenticated pairing, foreground screen-capture service तथा उपयोगकर्ता द्वारा
स्पष्ट रूप से चालू की गई Accessibility Service की अलग implementation और testing चाहिए।

सुरक्षा:
- Receiver फोन पर स्क्रीन शेयरिंग की अनुमति Android स्वयं दिखाता है।
- ऐप छिपकर स्क्रीन नहीं देखता।
- Android के secure screens और protected content को bypass करने का प्रयास नहीं किया गया।

Build:
1. ZIP को extract करें।
2. Android Studio में Open चुनकर TakRemote folder खोलें।
3. Gradle sync पूरा होने दें।
4. Run दबाकर अपने Android फोन पर install करें.

यह source project है, APK नहीं। इस वातावरण में Android SDK/Gradle build करके
installable APK बनाना संभव नहीं हुआ।
