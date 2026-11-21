import "definitions" from 'de.evoal.optimisation.constraint';
import "data" from 'search';

/**
 * Correlations estimated by 'correlation-estimation' from output/data.csv (example
 *   correlation-estimation), strongest first: the correlation-aware operators use the first
 *   correlation of a feature.
 */
module 'estimated-correlations' {
	constraints:
<#list correlations?sort_by("absoluteCoefficient")?reverse as c>
		// ${c.kind}, n = ${c.n}, ${c.confidenceLevel * 100} % confidence interval [${c.confidenceLower}, ${c.confidenceUpper}]
<#if c.ranged>
		'ranged-correlation'(data '${c.first}', range(${c.firstLower}, ${c.firstUpper}), data '${c.second}', range(${c.secondLower}, ${c.secondUpper}), ${c.coefficient});
<#else>
		correlation(data '${c.first}', data '${c.second}', ${c.coefficient});
</#if>
</#list>
}
