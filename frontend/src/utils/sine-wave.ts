export function generateSineWavePoints(
	amplitude: number,
	frequency: number,
	phaseShift: number,
	samples: number
) {
	const points: [number, number][] = [];
	const twoPi = 2 * Math.PI;

	for (let i = 0; i < samples; i++) {
		const x = i / (samples - 1);
		const y = amplitude * Math.sin(twoPi * frequency * x + phaseShift);
		points.push([x, y]);
	}

	return points;
}
