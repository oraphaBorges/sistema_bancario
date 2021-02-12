let Card = {
  render: (info) => {
    let view = `
    <div class="card-dashboard--default">
      ${info}
    </div>`;
    return view
  }
}
export default Card