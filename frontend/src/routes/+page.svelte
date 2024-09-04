<script>
	import Plot from '$lib/plot.svelte';
	import Websocket from '../infrastructure/websocket.svelte';
</script>

<main>
	<h1>Smart Plotting</h1>
	<p>Dashboard for smart plotting</p>

	<Plot />
	<Websocket />
</main>

<style lang="scss">
	main {
		width: 100%;
		height: 100%;

		display: grid;
		grid-template-rows: min-content min-content auto;
	}
</style>
