# CleanArchitecture

Problem stmt:
version 1:
1. Build an App that can chat with a bot server.
2. Single screen similar to a whatsapp chat screen
3. With edit box and send button at the bottom of the screen.
4. Connect external API of Chat server to send & receive messages [API details
mentioned below]
version 2: [attempt ver2.0 only after ver1.0 is completed in all respects]
1. Store and display past history messages - both sent and received


API
Details:
Host URL: http://www.personalityforge.com/api/chat/
Method : GET GET Parameters:
apiKey: *** chatBotID: 63906 externalID:
<yourname> message: <whatever user types in the edit box when
pressing send>

To test try click this URL: [Try to use AFNetworking
Library for making HTTP requests]
http://www.personalityforge.com/api/chat/?apiKey=6nt5d1nJHkqbkphe&message=Hi&chatBotI

D =63906&externalID=chirag1
Sample RESPONSE JSON:
{"success":1,"errorMessage":"","message":{"chatBotName":"Cybe
r Ty","chatBotID":63906,"message":"sup?","emotion":null}}
