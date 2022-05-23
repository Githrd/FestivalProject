$(document).ready(function() {
  const drawStar = (target) => {
  $(`.star span`).css({ width: `${target.value * 10}%` });
}
});