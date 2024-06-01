
<template>
<EventDetail id="$route.params.id"/>

</template>
<script setup>
import axios from "axios";
import EventDetail from "@/components/EventDetail.vue";

</script>

<style>
.wrapper-event {
  border: 1px solid #ccc;
  border-radius: .5rem;
  margin-bottom: .5rem;
  padding: .5rem;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.content-event-card {
  margin-bottom: 1rem;

}
</style>