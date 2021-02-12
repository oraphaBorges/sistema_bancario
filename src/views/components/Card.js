let Card = {
  render: (info) => {
    let view = `
    <div class="card-dashboard--default">
      <div>
        ${info}
      </div> 
    </div>`;
    return view
  }
}
export default Card