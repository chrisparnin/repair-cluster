String.prototype.escapeSpecialChars = function() {
    return this.replace(/\\n/g, "\n")
               .replace(/\\'/g, "\'")
               .replace(/\\"/g, '\"')
               .replace(/\\\//g, '/')
               .replace(/\\&/g, "\&")
               .replace(/\\r/g, "\r")
               .replace(/\\t/g, "\t")
               .replace(/\\b/g, "\b")
               .replace(/\\f/g, "\f");
};

let x = {"PATCH_DIFF":"--- \\\/astor\\\/.\\\/output_astor\\\/AstorMain-MATH1021Test\\\/src\\\/default\\\/org\\\/apache\\\/commons\\\/math3\\\/distribution\\\/AbstractIntegerDistribution.java\\t\\n+++ \\\/astor\\\/.\\\/output_astor\\\/AstorMain-MATH1021Test\\\/src\\\/variant-188\\\/org\\\/apache\\\/commons\\\/math3\\\/distribution\\\/AbstractIntegerDistribution.java\\t\\n@@ -55,8 +55,8 @@\\n \\t\\t\\t}\\n \\t\\t\\tk = 1.0 \\\/ k;\\n \\t\\t\\ttmp = mu + (k * sigma);\\n-\\t\\t\\tif (tmp < upper) {\\n-\\t\\t\\t\\tupper = ((int) (java.lang.Math.ceil(tmp))) - 1;\\n+\\t\\t\\tif ((p < 0) || (p > 1)) {\\n+\\t\\t\\t\\tthrow new org.apache.commons.math3.exception.OutOfRangeException(p, 0, 1);\\n \\t\\t\\t}\\n \\t\\t}\\n \\t\\treturn solveInverseCumulativeProbability(p, lower, upper);\\n\\n"};

let b = x.PATCH_DIFF.escapeSpecialChars();