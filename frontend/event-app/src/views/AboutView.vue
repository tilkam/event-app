<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
  <CreateEvent/>
  <Datepicker
      lang="en"
      range
      v-model="selectedDate"/>
</template>


<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
<script>

import 'vue-datepicker-ui/lib/vuedatepickerui.css';
import VueDatepickerUi from 'vue-datepicker-ui';
import CreateEvent from "@/components/CreateEvent.vue";

export default {
  components: {
    CreateEvent,
    Datepicker: VueDatepickerUi,
    data() {
      return {
        selectedDate: [
          new Date(),
          new Date(new Date().getTime() + 9 * 24 * 60 * 60 * 1000)]
      }
    }
  }

}
</script>