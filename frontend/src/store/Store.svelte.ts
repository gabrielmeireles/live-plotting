import { writable, type Writable } from 'svelte/store';

class Store {
	plotData: Writable<[number, number][]> = writable<[number, number][]>([]);
	constructor() {
		setInterval(() => {
			const newData: [number, number] = [new Date().getTime(), Math.random()];
			this.plotData.update((pd) => [...pd, newData]);
		}, 50);
	}

	subscribe(fn: (data: [number, number][]) => void) {
		return this.plotData.subscribe(fn);
	}
}

export const store = new Store();
