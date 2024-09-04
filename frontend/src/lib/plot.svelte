<script lang="ts">
	import * as d3 from 'd3';
	import { onMount } from 'svelte';
	import { store } from '../store/Store.svelte';

	let vis: HTMLElement;

	let data = $derived($store);

	let width: number;
	let height: number;

	const margin = {
		top: 30,
		right: 30,
		bottom: 30,
		left: 30
	};

	onMount(() => {
		window.addEventListener('resize', redraw);
	});

	$effect(() => {
		redraw();
	});

	function redraw(): void {
		d3.select(vis).html(null);

		const node = d3.select(vis).node();
		if (!node) return;

		width = node.getBoundingClientRect().width - margin.left - margin.right;
		height = node.getBoundingClientRect().height - margin.top - margin.bottom;

		const svg = d3
			.select(vis)
			.append('svg')
			.attr('width', width + margin.left + margin.right)
			.attr('height', height + margin.top + margin.bottom)
			.append('g')
			.attr('transform', `translate(${[margin.left, margin.top]})`);

		var x = d3
			.scaleLinear()
			.domain(d3.extent(data, (d) => d[0]) as [number, number])
			.range([0, width]);

		var y = d3
			.scaleLinear()
			.domain(d3.extent(data, (d) => d[1]) as [number, number])
			.range([height, 0]);

		svg
			.append('g')
			.attr('transform', 'translate(0,' + height + ')')
			.call(d3.axisBottom(x));

		svg.append('g').call(d3.axisLeft(y));

		svg
			.append('path')
			.datum(data)
			.attr('fill', 'none')
			.attr('stroke', 'steelblue')
			.attr('stroke-width', 1.5)
			.attr(
				'd',
				d3
					.line()
					.x((d) => x(d[0]))
					.y((d) => y(d[1]))
			);
	}
</script>

<div id="vis" bind:this={vis}></div>

<style>
	#vis {
		width: 100%;
		height: 100%;
		background-color: whitesmoke;
	}
</style>
