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
2. Add a hamburger menu equivalent and have multiple chat screens on click of
list
version 3: [attempt ver3.0 only after ver2.0 is completed in all respects]
1. Get the app to work offline - where message is stored locally and sent to server
once internet is on

API
Details:
Host URL: http://www.personalityforge.com/api/chat/
Method : GET GET Parameters:
apiKey: 6nt5d1nJHkqbkphe chatBotID: 63906 externalID:
<yourname> message: <whatever user types in the edit box when
pressing send>

To test try click this URL: [Try to use AFNetworking
Library for making HTTP requests]
http://www.personalityforge.com/api/chat/?apiKey=6nt5d1nJHkqbkphe&message=Hi&chatBotI

D =63906&externalID=chirag1
Sample RESPONSE JSON:
{"success":1,"errorMessage":"","message":{"chatBotName":"Cybe
r Ty","chatBotID":63906,"message":"sup?","emotion":null}}

Requirements :
1. All code should be hosted in github/bitbucket and shared with us at the beginning
of the project via balaji@docsapp.in, diptika.shukla@docsapp.in
2. Commit regularly to enable us to see the progress through the development process.
(This will help us evaluate even partially complete scenarios)
3. Document the code and Architecture along with DB tables(if applicable) and columns
and their purposes. Mention any other assumptions made.
4. UI of App - A single screen App would be fine
5. Reach out to Balaji @ 07204839178 or Diptika @ 09686009203 for any queries.
6. Take screenshots of the “App in action” for demo upon completion & send in the
email
7. Send ipa of the completed app & name them with version - say : chatbot_ver1.ipa,
chatbot_ver2.ipa ,chatbot_ver3.ipa as each set is completed if possible.
8. Tag the commits with appropriate version numbers and push the tags as well.
ChatScreen
UI:
Refer to WhatsApp / Telegram or chat apps
1. Navigation bar with title as ChatBot
2. UITextField with a SEND Button at the bottom of the screen. Which scrolls up when
keyboard appears.
3. In the middle chat messages to be displayed in chat bubbles - sent messages on
the right and received messages
4. Extra points for Good Design & using iOS design UI & UX
guidelines.
