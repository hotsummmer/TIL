const Task = class{
  constructor(title, date){
    if(!title) throw 'invalid title';
    this._title = title;
    this._date = date;
    this._isComplete = false;
    this._list = [];
  }
  isComplete(){return this._isCompelete;}
  toggle(){this._isComplete = !this._isComplete};
  add(title, date = null){this._list.push(new Task(title, date));}
  remove(task){ //title or id shouldn't be argument
    if(!(task instanceof Task)) throw 'Invalid type of task';
    const list = this._list;
    if(list.includes(task)) list.splice(list.indexOf(task), 1);
  }
  byTitle(stateGroup = true){return this.list('title', stateGroup);}
  byDate(stateGroup = true){return this.list('date', stateGroup);}
  list(sort, stateGroup = true){
    const f = (a, b)=>a['_' + sort] > b['_' + sort];
    this._getList(f, stateGroup);
  }
  _getList(sort, stateGroup){
    const list = this._list, map = task=>task.list(sort, stateGroup);
    return {
      task : this,
      list : !stateGroup ? [...list].sort(sort).map(map) : [
        ...list.filter(v=>!v.isComplete()).sort(sort).map(map),
        ...list.filter(v=>v.isComplete()).sort(sort).map(map)
      ]
    }
  }
}
const el = (tag, attr = {})=>Object.entries(attr).reduce((el, v)=>{
  typeof el[v[0]] == 'function' ? el[v[0]](v[1]) : (el[v[0]] = v[1]); //함수는 call해주고 아니면 할당해줄게~
  return el;
} ,document.createElement(tag));
const DomRenderer = class{
  constructor(parent){
    this._parent = parent;
  }
  render(data){//이 data는 task키와 list를 가지고 있다는 약속을 하고 있음.
    const {task:{_title:title}, list} = data;
    const parent = document.getSelector(this._parent);
    parent.innerHTML = '';
    parent.appendChild(el('h1', {innerHTML:title})); //부모 엘리먼트와    --> 이 게 반 복
    parent.appendChild(this._render(el('ul'), list)); // 리스트를 받는다  -->
  }
  _render(parent, list){
    list.forEach(({task, list})=>{
      const li = parent.appendChild('li');
      li.appendChild(el('div', {innerHTML:task._title}));
      li.appendChild(this._render(el('ul'), list));
    });
    return parent;
  }
}
const root = new Task('1');
const list1 = new Task('개발');
list1.add('코드스피츠 강의 수강');
list1.add('지라 클라우드 접속');

const list2 = new Task('운동');
list1.add('요가');
list1.add('달리기 30분');
const {list} = list2.byTitle();
list[1].task.add('todo.js 복기');
list[1].task.add('ES6 문법 체크');
