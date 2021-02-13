let Card = {
  render: (info) => {
    let view = `
    <div class="card">
      ${info}
    </div>`;
    return view
  }
}
export default Card