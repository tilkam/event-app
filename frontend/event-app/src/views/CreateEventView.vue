<template>
  <div class="create-event-view">
  </div>
  <CreateEvent/>
  <!-- <Datepicker
       lang="en"
       range
       v-model="selectedDate"/>-->
</template>

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
