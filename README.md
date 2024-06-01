Detta är en Spring Boot-applikation som körs med Maven och Java 17 som ska bli en app för att skapa och anmäla sig till event.

Backend:<br>
Starta en docker container för att köra MySQL på port 3306 - detta görs i docker desktop(Går bra med en annan port också, glöm ej att ändra i application.properties bara)

Starta applikationen:
```shell
mvn spring-boot:run
```
Applikationen körs på port 8080.

Starta frontend första gången:
```shell
  cd frontend/event-app
  npm install
  npm run format
  npm run dev
```

Sedan kan du starta frontend med:
```shell
  npm run dev
```

Frontend körs på http://localhost:5173/

Versioner:<br>
node:
v18.17.0<br>
npm:
10.8.1

Länkar:<br>
https://edisdev.github.io/vue-datepicker-ui/props.html#value-modelvalue
https://vuejs.org/guide/components/events.html
https://www.shadcn-vue.com/examples/cards.html
https://www.radix-vue.com/components/popover.html
